/*
 * The MIT License (MIT)
 *
 * Copyright 2015 Valentyn Kolesnikov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.underscore.lodash;

import java.util.*;
import com.github.underscore.Predicate;

public class $<T> extends com.github.underscore.$<T> {

    public $(final Iterable<T> iterable) {
        super(iterable);
    }

    public $(final String string) {
        super(string);
    }

    public static class Chain<T> extends com.github.underscore.$.Chain<T> {
        public Chain(final T item) {
            super(item);
        }
        public Chain(final List<T> list) {
            super(list);
        }

        public Chain<List<List<T>>> chunk(final Integer size) {
            return new Chain<List<List<T>>>($.chunk(value(), size));
        }

        public Chain<List<T>> drop() {
            return new Chain<List<T>>($.drop(value()));
        }

        public Chain<List<T>> drop(final Integer n) {
            return new Chain<List<T>>($.drop(value(), n));
        }

        public Chain<List<T>> dropRight() {
            return new Chain<List<T>>($.dropRight(value()));
        }

        public Chain<List<T>> dropRight(final Integer n) {
            return new Chain<List<T>>($.dropRight(value(), n));
        }

        public Chain<List<T>> dropWhile(final Predicate<T> pred) {
            return new Chain<List<T>>($.dropWhile(value(), pred));
        }
    }

    public static Chain chain(final String item) {
        return new $.Chain<String>(item);
    }

    public static <T> Chain chain(final List<T> list) {
        return new $.Chain<T>(list);
    }

    public static <T> Chain chain(final Set<T> list) {
        return new $.Chain<T>(newArrayList(list));
    }

    public static <T> Chain chain(final T ... list) {
        return new $.Chain<T>(Arrays.asList(list));
    }

    public static <T> List<List<T>> chunk(final Iterable<T> iterable, final Integer size) {
        int index = 0;
        int length = size(iterable);
        final List<List<T>> result = new ArrayList<List<T>>(length / size);
        while (index < length) {
            result.add(newArrayList(iterable).subList(index, Math.min(length, index + size)));
            index += size;
        }
        return result;
    }

    public List<List<T>> chunk(final Integer size) {
        return chunk(getIterable(), size);
    }

    public static <T> List<T> drop(final Iterable<T> iterable) {
        return rest(newArrayList(iterable));
    }

    public List<T> drop() {
        return drop(getIterable());
    }

    public static <T> List<T> drop(final Iterable<T> iterable, final Integer n) {
        return rest(newArrayList(iterable), n);
    }

    public List<T> drop(final Integer n) {
        return drop(getIterable(), n);
    }

    public static <T> List<T> dropRight(final Iterable<T> iterable) {
        return initial(newArrayList(iterable));
    }

    public List<T> dropRight() {
        return dropRight(getIterable());
    }

    public static <T> List<T> dropRight(final Iterable<T> iterable, final Integer n) {
        return initial(newArrayList(iterable), n);
    }

    public List<T> dropRight(final Integer n) {
        return dropRight(getIterable(), n);
    }

    public static <T> List<T> dropWhile(final Iterable<T> iterable, final Predicate<T> pred) {
        return rest(newArrayList(iterable), findIndex(newArrayList(iterable), negate(pred)));
    }

    public List<T> dropWhile(final Predicate<T> pred) {
        return dropWhile(getIterable(), pred);
    }

    public static void main(String ... args) {
        final String message = "Underscore-java-lodash is a lodash plugin for underscore-java.\n\n"
            + "For docs, license, tests, and downloads, see: http://javadev.github.io/underscore-java";
        System.out.println(message);
    }
}
