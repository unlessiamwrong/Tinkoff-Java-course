package edu.project4;

public record FractalImageConfig(
    int samplesCount,
    int iterationsCount,
    String nonLinearType
) {
}
