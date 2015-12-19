package work.samoje.colors.modification.filter.filters;

/**
 * Abstract filter instance which applies the filter with an intensity dictated
 * by the specified multiplier.
 *
 * @author Jennie Sadler
 */
public abstract class IntensityFilter implements Filter {
    private final double intensity;

    public IntensityFilter(final int multiplier, final int maxMultiplier) {
        this.intensity = (multiplier * 1.0) / maxMultiplier;
    }

    /**
     * Helper method. Returns the integer value nearest the given double value
     * that is in the range [0, 255].
     *
     * @param value
     *            Any double value
     * @return The integer value nearest to the provided in [0, 255]. May be
     *         equal to the given value.
     */
    protected int boundByColorRange(final double value) {
        return Math.max(0, (int) Math.min(ColorHelpers.MAX_COLOR_VAL, value));
    }

    /**
     * Applies the filter intensity given the original color value and the
     * filtered color value.
     *
     * Does this with the following calculation:
     *
     * result = original(1 - intensity) + (filtered * intensity)
     *
     * @param original
     *            The original int value, before the filter is applied
     * @param filtered
     *            The filtered int value, to be applied by the configured
     *            intensity.
     * @return The result value, filtered to the correct intensity
     */
    protected int applyIntensity(final int original, final int filtered) {
        return boundByColorRange((original * (1.0 - intensity))
                + (filtered * intensity));
    }
}
