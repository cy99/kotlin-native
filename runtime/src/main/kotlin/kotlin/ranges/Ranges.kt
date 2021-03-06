/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlin.ranges

/**
 * A range of values of type `Char`.
 */
public class CharRange(start: Char, endInclusive: Char) : CharProgression(start, endInclusive, 1), ClosedRange<Char> {
    override val start: Char get() = first
    override val endInclusive: Char get() = last

    override fun contains(value: Char): Boolean = first <= value && value <= last

    override fun isEmpty(): Boolean = first > last

    override fun equals(other: Any?): Boolean =
            other is CharRange && (isEmpty() && other.isEmpty() ||
                    first == other.first && last == other.last)

    override fun hashCode(): Int =
            if (isEmpty()) -1 else (31 * first.toInt() + last.toInt())

    override fun toString(): String = "$first..$last"

    companion object {
        /** An empty range of values of type Char. */
        public val EMPTY: CharRange = CharRange(1.toChar(), 0.toChar())
    }
}

/**
 * A range of values of type `Int`.
 */
public class IntRange(start: Int, endInclusive: Int) : IntProgression(start, endInclusive, 1), ClosedRange<Int> {
    override val start: Int get() = first
    override val endInclusive: Int get() = last

    override fun contains(value: Int): Boolean = first <= value && value <= last

    override fun isEmpty(): Boolean = first > last

    override fun equals(other: Any?): Boolean =
            other is IntRange && (isEmpty() && other.isEmpty() ||
                    first == other.first && last == other.last)

    override fun hashCode(): Int =
            if (isEmpty()) -1 else (31 * first + last)

    override fun toString(): String = "$first..$last"

    companion object {
        /** An empty range of values of type Int. */
        public val EMPTY: IntRange = IntRange(1, 0)
    }
}

/**
 * A range of values of type `Long`.
 */
public class LongRange(start: Long, endInclusive: Long) : LongProgression(start, endInclusive, 1), ClosedRange<Long> {
    override val start: Long get() = first
    override val endInclusive: Long get() = last

    override fun contains(value: Long): Boolean = first <= value && value <= last

    override fun isEmpty(): Boolean = first > last

    override fun equals(other: Any?): Boolean =
            other is LongRange && (isEmpty() && other.isEmpty() ||
                    first == other.first && last == other.last)

    override fun hashCode(): Int =
            if (isEmpty()) -1 else (31 * (first xor (first ushr 32)) + (last xor (last ushr 32))).toInt()

    override fun toString(): String = "$first..$last"

    companion object {
        /** An empty range of values of type Long. */
        public val EMPTY: LongRange = LongRange(1, 0)
    }
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the
[minimumValue] otherwise.
 */
public fun <T: Comparable<T>> T.coerceAtLeast(minimumValue: T): T {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
public fun Byte.coerceAtLeast(minimumValue: Byte): Byte {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
public fun Short.coerceAtLeast(minimumValue: Short): Short {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
public fun Int.coerceAtLeast(minimumValue: Int): Int {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
public fun Long.coerceAtLeast(minimumValue: Long): Long {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
public fun Float.coerceAtLeast(minimumValue: Float): Float {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
public fun Double.coerceAtLeast(minimumValue: Double): Double {
    return if (this < minimumValue) minimumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun <T: Comparable<T>> T.coerceAtMost(maximumValue: T): T {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun Byte.coerceAtMost(maximumValue: Byte): Byte {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun Short.coerceAtMost(maximumValue: Short): Short {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun Int.coerceAtMost(maximumValue: Int): Int {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun Long.coerceAtMost(maximumValue: Long): Long {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun Float.coerceAtMost(maximumValue: Float): Float {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
public fun Double.coerceAtMost(maximumValue: Double): Double {
    return if (this > maximumValue) maximumValue else this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun <T: Comparable<T>> T.coerceIn(minimumValue: T?, maximumValue: T?): T {
    if (minimumValue !== null && maximumValue !== null) {
        if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
        if (this < minimumValue) return minimumValue
        if (this > maximumValue) return maximumValue
    }
    else {
        if (minimumValue !== null && this < minimumValue) return minimumValue
        if (maximumValue !== null && this > maximumValue) return maximumValue
    }
    return this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun Byte.coerceIn(minimumValue: Byte, maximumValue: Byte): Byte {
    if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    if (this < minimumValue) return minimumValue
    if (this > maximumValue) return maximumValue
    return this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun Short.coerceIn(minimumValue: Short, maximumValue: Short): Short {
    if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    if (this < minimumValue) return minimumValue
    if (this > maximumValue) return maximumValue
    return this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun Int.coerceIn(minimumValue: Int, maximumValue: Int): Int {
    if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    if (this < minimumValue) return minimumValue
    if (this > maximumValue) return maximumValue
    return this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun Long.coerceIn(minimumValue: Long, maximumValue: Long): Long {
    if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    if (this < minimumValue) return minimumValue
    if (this > maximumValue) return maximumValue
    return this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun Float.coerceIn(minimumValue: Float, maximumValue: Float): Float {
    if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    if (this < minimumValue) return minimumValue
    if (this > maximumValue) return maximumValue
    return this
}

/**
 * Ensures that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or [maximumValue] if this value is greater than [maximumValue].
 */
public fun Double.coerceIn(minimumValue: Double, maximumValue: Double): Double {
    if (minimumValue > maximumValue) throw IllegalArgumentException("Cannot coerce value to an empty range: maximum $maximumValue is less than minimum $minimumValue.")
    if (this < minimumValue) return minimumValue
    if (this > maximumValue) return maximumValue
    return this
}

/**
 * Ensures that this value lies in the specified [range].
 *
 * @return this value if it's in the [range], or range.start if this value is less than range.start, or range.end if this value is greater than range.end.
 */
public fun <T: Comparable<T>> T.coerceIn(range: ClosedRange<T>): T {
    if (range.isEmpty()) throw IllegalArgumentException("Cannot coerce value to an empty range: $range.")
    return if (this < range.start) range.start else if (this > range.endInclusive) range.endInclusive else this
}

/**
 * Ensures that this value lies in the specified [range].
 *
 * @return this value if it's in the [range], or range.start if this value is less than range.start, or range.end if this value is greater than range.end.
 */
public fun Int.coerceIn(range: ClosedRange<Int>): Int {
    if (range.isEmpty()) throw IllegalArgumentException("Cannot coerce value to an empty range: $range.")
    return if (this < range.start) range.start else if (this > range.endInclusive) range.endInclusive else this
}

/**
 * Ensures that this value lies in the specified [range].
 *
 * @return this value if it's in the [range], or range.start if this value is less than range.start, or range.end if this value is greater than range.end.
 */
public fun Long.coerceIn(range: ClosedRange<Long>): Long {
    if (range.isEmpty()) throw IllegalArgumentException("Cannot coerce value to an empty range: $range.")
    return if (this < range.start) range.start else if (this > range.endInclusive) range.endInclusive else this
}


internal fun checkStepIsPositive(isPositive: Boolean, step: Number) {
    if (!isPositive) throw IllegalArgumentException("Step must be positive, was: $step.")
}

// This part is from generated _Ranges.kt.
/**
 * Returns a progression that goes over the same range in the opposite direction with the same step.
 */
public fun IntProgression.reversed() = IntProgression.fromClosedRange(last, first, -step)

/**
 * Returns a progression that goes over the same range with the given step.
 */
public infix fun IntProgression.step(step: Int): IntProgression {
    checkStepIsPositive(step > 0, step)
    return IntProgression.fromClosedRange(first, last, if (this.step > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step.
 */
public infix fun LongProgression.step(step: Long): LongProgression {
    checkStepIsPositive(step > 0, step)
    return LongProgression.fromClosedRange(first, last, if (this.step > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step.
 */
public infix fun CharProgression.step(step: Int): CharProgression {
    checkStepIsPositive(step > 0, step)
    return CharProgression.fromClosedRange(first, last, if (this.step > 0) step else -step)
}

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Int.downTo(to: Byte) = IntProgression.fromClosedRange(this, to.toInt(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Long.downTo(to: Byte) = LongProgression.fromClosedRange(this, to.toLong(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Byte.downTo(to: Byte): IntProgression =
        IntProgression.fromClosedRange(this.toInt(), to.toInt(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Short.downTo(to: Byte) =
        IntProgression.fromClosedRange(this.toInt(), to.toInt(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Char.downTo(to: Char): CharProgression = CharProgression.fromClosedRange(this, to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Int.downTo(to: Int) = IntProgression.fromClosedRange(this, to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Long.downTo(to: Int) = LongProgression.fromClosedRange(this, to.toLong(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Byte.downTo(to: Int): IntProgression =
        IntProgression.fromClosedRange(this.toInt(), to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Short.downTo(to: Int) = IntProgression.fromClosedRange(this.toInt(), to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Int.downTo(to: Long) = LongProgression.fromClosedRange(this.toLong(), to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Long.downTo(to: Long) = LongProgression.fromClosedRange(this, to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Byte.downTo(to: Long): LongProgression =
        LongProgression.fromClosedRange(this.toLong(), to, -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Int.downTo(to: Short) = IntProgression.fromClosedRange(this, to.toInt(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Long.downTo(to: Short) = LongProgression.fromClosedRange(this, to.toLong(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Byte.downTo(to: Short): IntProgression =
        IntProgression.fromClosedRange(this.toInt(), to.toInt(), -1)

/**
 * Returns a progression from this value down to the specified [to] value with the step -1.
 *
 * The [to] value has to be less than this value.
 */
public infix fun Short.downTo(to: Short): IntProgression =
        IntProgression.fromClosedRange(this.toInt(), to.toInt(), -1)

/**
 * Represents a range of floating point numbers.
 * Extends [ClosedRange] interface providing custom operation [lessThanOrEquals] for comparing values of range domain type.
 *
 * This interface is implemented by floating point ranges returned by [Float.rangeTo] and [Double.rangeTo] operators to
 * achieve IEEE-754 comparison order instead of total order of floating point numbers.
 */
public interface ClosedFloatingPointRange<T: Comparable<T>> : ClosedRange<T> {
    override fun contains(value: T): Boolean = lessThanOrEquals(start, value) && lessThanOrEquals(value, endInclusive)
    override fun isEmpty(): Boolean = !lessThanOrEquals(start, endInclusive)

    /**
     * Compares two values of range domain type and returns true if first is less than or equal to second.
     */
    fun lessThanOrEquals(a: T, b: T): Boolean
}

/**
 * Represents a range of [Comparable] values.
 */
private open class ComparableRange<T: Comparable<T>> (
        override val start: T,
        override val endInclusive: T
): ClosedRange<T> {

    override fun equals(other: Any?): Boolean {
        return other is ComparableRange<*> && (isEmpty() && other.isEmpty() ||
                start == other.start && endInclusive == other.endInclusive)
    }

    override fun hashCode(): Int {
        return if (isEmpty()) -1 else 31 * start.hashCode() + endInclusive.hashCode()
    }

    override fun toString(): String = "$start..$endInclusive"
}

/**
 * A closed range of values of type `Double`.
 *
 * Numbers are compared with the ends of this range according to IEEE-754.
 */
private class ClosedDoubleRange (
        start: Double,
        endInclusive: Double
) : ClosedFloatingPointRange<Double> {
    private val _start = start
    private val _endInclusive = endInclusive
    override val start: Double get() = _start
    override val endInclusive: Double get() = _endInclusive

    override fun lessThanOrEquals(a: Double, b: Double): Boolean = a <= b

    override fun contains(value: Double): Boolean = value >= _start && value <= _endInclusive
    override fun isEmpty(): Boolean = !(_start <= _endInclusive)

    override fun equals(other: Any?): Boolean {
        return other is ClosedDoubleRange && (isEmpty() && other.isEmpty() ||
                _start == other._start && _endInclusive == other._endInclusive)
    }

    override fun hashCode(): Int {
        return if (isEmpty()) -1 else 31 * _start.hashCode() + _endInclusive.hashCode()
    }
    override fun toString(): String = "$_start..$_endInclusive"
}

/**
 * A closed range of values of type `Float`.
 *
 * Numbers are compared with the ends of this range according to IEEE-754.
 */
private class ClosedFloatRange (
        start: Float,
        endInclusive: Float
): ClosedFloatingPointRange<Float> {
    private val _start = start
    private val _endInclusive = endInclusive
    override val start: Float get() = _start
    override val endInclusive: Float get() = _endInclusive

    override fun lessThanOrEquals(a: Float, b: Float): Boolean = a <= b

    override fun contains(value: Float): Boolean = value >= _start && value <= _endInclusive
    override fun isEmpty(): Boolean = !(_start <= _endInclusive)

    override fun equals(other: Any?): Boolean {
        return other is ClosedFloatRange && (isEmpty() && other.isEmpty() ||
                _start == other._start && _endInclusive == other._endInclusive)
    }

    override fun hashCode(): Int {
        return if (isEmpty()) -1 else 31 * _start.hashCode() + _endInclusive.hashCode()
    }
    override fun toString(): String = "$_start..$_endInclusive"
}

/**
 * Creates a range from this [Comparable] value to the specified [that] value.
 *
 * This value needs to be smaller than [that] value, otherwise the returned range will be empty.
 */
public operator fun <T: Comparable<T>> T.rangeTo(that: T): ClosedRange<T> = ComparableRange(this, that)

/**
 * Creates a range from this [Double] value to the specified [other] value.
 *
 * Numbers are compared with the ends of this range according to IEEE-754.
 */
public operator fun Double.rangeTo(that: Double): ClosedFloatingPointRange<Double> = ClosedDoubleRange(this, that)

/**
 * Creates a range from this [Float] value to the specified [other] value.
 *
 * Numbers are compared with the ends of this range according to IEEE-754.
 */
public operator fun Float.rangeTo(that: Float): ClosedFloatingPointRange<Float> = ClosedFloatRange(this, that)
