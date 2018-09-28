package ru.academist.krukova.range;

public class Range {
    private double from;
    private double to;
    public static final double epsilon = 1.0e-10;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number - from >= -epsilon) && (to - number >= -epsilon);
    }

    public Range getCrossing(Range range) {
        double crossFrom;
        double crossTo;

        if (this.isInside(range.from) || (range.isInside(this.from))) {
            crossFrom = (this.from > range.from) ? this.from : range.from;
            crossTo = (this.to < range.to) ? this.to : range.to;
            return new Range(crossFrom, crossTo);
        }

        return null;
    }

    public Range[] getMerger(Range range) {
        Range[] mergerRange = new Range[2];

        if (this.isInside(range.from) || (range.isInside(this.from))) {
            mergerRange[0] = new Range(0, 0);
            mergerRange[0].setFrom((this.from < range.from) ? this.from : range.from);
            mergerRange[0].setTo((this.to > range.to) ? this.to : range.to);
        } else {
            mergerRange[0] = new Range(this.from, this.to);
            mergerRange[1] = new Range(range.from, range.to);
        }

        return mergerRange;
    }

    public Range[] getResidual(Range range) {
        Range[] residualRange = new Range[2];

        Range crossRange = this.getCrossing(range);

        if (crossRange.getLength() == this.getLength()) {
            return residualRange;
        }

        if (crossRange.getLength() == 0) {
            residualRange[0] = this;
            return residualRange;
        }

        residualRange[0] = this;

        if (this.from == crossRange.from) {
            residualRange[0] = new Range(crossRange.to, this.to);
        } else if (this.to == crossRange.to) {
            residualRange[0] = new Range(this.from, crossRange.from);
        } else {
            residualRange[0] = new Range(this.from, crossRange.from);
            residualRange[1] = new Range(crossRange.to, this.to);
        }

        return residualRange;
    }
}
