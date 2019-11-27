package org.hkijena.microbench.tasks;

import net.imagej.ImageJ;
import net.imglib2.FinalDimensions;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.algorithm.convolution.Convolution;
import net.imglib2.algorithm.fft2.FFT;
import net.imglib2.algorithm.fft2.FFTConvolution;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgFactory;
import net.imglib2.img.display.imagej.ImageJFunctions;
import net.imglib2.type.numeric.real.FloatType;
import net.imglib2.view.Views;
import org.hkijena.microbench.DataInterface;
import org.hkijena.microbench.Filters;
import org.hkijena.microbench.Main;

public class Microbench extends DAGTask {

    public Microbench(Integer tid, DataInterface dataInterface) {
        super(tid, dataInterface);
    }

    @Override
    public void work() {
        System.out.println("Running Convolve on " + getDataInterface().toString());

        final ImageJ ij = Main.IMAGEJ;
        Img<FloatType> psf = getDataInterface().getPsfImage().getOrCreate();
        Img<FloatType> img = ImageJFunctions.convertFloat(ImageJFunctions.wrap(getDataInterface().getInputImage().getOrCreate(), "img"));
        RandomAccessibleInterval<FloatType> convolved_ = ij.op().filter().convolve(img, psf);
        Img<FloatType> convolved = (new ArrayImgFactory<>(new FloatType())).create(Filters.getDimensions(img));
        Filters.copy(convolved_, convolved);
        getDataInterface().getConvolvedImage().set(convolved);
    }
}
