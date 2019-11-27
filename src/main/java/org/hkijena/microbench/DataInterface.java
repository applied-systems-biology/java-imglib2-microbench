package org.hkijena.microbench;

import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.type.numeric.real.FloatType;
import org.hkijena.microbench.caches.TIFFImageCache;

import java.nio.file.Path;

public class DataInterface {

    private Path outputDirectory;
    private TIFFImageCache<UnsignedShortType> inputImage;
    private TIFFImageCache<FloatType> outputMedian;
    private TIFFImageCache<FloatType> outputMorphology;
    private TIFFImageCache<FloatType> outputFFTIFFT;
    private TIFFImageCache<FloatType> outputOtsu;
    private TIFFImageCache<FloatType> outputPercentile;
    private TIFFImageCache<FloatType> outputCanny;
    private TIFFImageCache<FloatType> outputWiener;

    public DataInterface(Path inputDirectory, Path outputDirectory) {
        this.outputDirectory = outputDirectory;
        inputImage = new TIFFImageCache<>(inputDirectory.resolve("in").resolve("data.tif"), new UnsignedShortType());
        outputMedian = new TIFFImageCache<>(outputDirectory.resolve("median_filtered.tif"), new FloatType(), inputImage);
        outputMorphology = new TIFFImageCache<>(outputDirectory.resolve("dilated.tif"), new FloatType(), inputImage);
        outputFFTIFFT = new TIFFImageCache<>(outputDirectory.resolve("fft_ifft.tif"), new FloatType(), inputImage);
        outputOtsu = new TIFFImageCache<>(outputDirectory.resolve("otsu.tif"), new FloatType(), inputImage);
        outputPercentile = new TIFFImageCache<>(outputDirectory.resolve("percentile.tif"), new FloatType(), inputImage);
        outputCanny = new TIFFImageCache<>(outputDirectory.resolve("canny_edges.tif"), new FloatType(), inputImage);
        outputWiener = new TIFFImageCache<>(outputDirectory.resolve("wiener2.tif"), new FloatType(), inputImage);
    }

    @Override
    public String toString() {
        return outputDirectory.toString();
    }

    public Path getOutputDirectory() {
        return outputDirectory;
    }

    public TIFFImageCache<UnsignedShortType> getInputImage() {
        return inputImage;
    }

    public TIFFImageCache<FloatType> getOutputMedian() {
        return outputMedian;
    }

    public TIFFImageCache<FloatType> getOutputMorphology() {
        return outputMorphology;
    }

    public TIFFImageCache<FloatType> getOutputFFTIFFT() {
        return outputFFTIFFT;
    }

    public TIFFImageCache<FloatType> getOutputOtsu() {
        return outputOtsu;
    }

    public TIFFImageCache<FloatType> getOutputPercentile() {
        return outputPercentile;
    }

    public TIFFImageCache<FloatType> getOutputCanny() {
        return outputCanny;
    }

    public TIFFImageCache<FloatType> getOutputWiener() {
        return outputWiener;
    }
}
