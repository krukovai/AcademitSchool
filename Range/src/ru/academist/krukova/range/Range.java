package ru.academist.krukova.range;

public class Range {
    private double from;
    private double to;

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
        return (number >= from) && (number <= to);
    }

    public Range getCrossing(Range range) {
        if (Math.max(this.from, range.from) <= Math.min(this.to, range.to)) {
            double crossFrom = Math.max (this.from, range.from);
            double crossTo = Math.min (this.to, range.to);
            return new Range(crossFrom, crossTo);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (Math.max(this.from, range.from) <= Math.min(this.to, range.to)) {
            return new Range[]{new Range(Math.min (this.from, range.from), Math.max (this.to, range.to))};
        } else {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }
    }

    public Range[] getResidual(Range range)  {
        if (this.from >= range.from && this.to <= range.to) {
            return new Range[] {};
        }

        if (this.from > range.to || this.to < range.from) {
            return new Range[]{new Range(this.from, this.to)};
        }

        if (this.from >= range.from && this.to > range.to) {
            return new Range[]{new Range(range.to, this.to)};
        } else if (this.to <= range.to && this.from < range.from) {
            return new Range[]{new Range(this.from, range.from)};
        } else {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }
    }
}
