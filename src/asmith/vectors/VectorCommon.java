//	Copyright 2017 Adam Smith
//
//	Licensed under the Apache License, Version 2.0 (the "License");
//	you may not use this file except in compliance with the License.
//	You may obtain a copy of the License at
//
//	http://www.apache.org/licenses/LICENSE-2.0
//
//	Unless required by applicable law or agreed to in writing, software
//	distributed under the License is distributed on an "AS IS" BASIS,
//	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//	See the License for the specific language governing permissions and
//	limitations under the License.

package asmith.vectors;

import java.util.Arrays;

/**
 * Implements most vector operations for a generic type.
 * @author Adam Smith
 *
 * @param <T> The element type of the vector.
 */
public abstract class VectorCommon<T> implements Vector<T> {

	/**
	 * Calculate the square root of an elements.
	 * @param aValue The value.
	 * @return The square root of the value.
	 */
	protected abstract T sqrt(T aValue);
	
	/**
	 * Add two elements.
	 * @param aA The left hand element.
	 * @param aB The right hand element.
	 * @return The result of the operation.
	 */
	protected abstract T add(T aA, T aB);
	
	/**
	 * Subtract two elements.
	 * @param aA The left hand element.
	 * @param aB The right hand element.
	 * @return The result of the operation.
	 */
	protected abstract T sub(T aA, T aB);
	
	/**
	 * Multiply two elements.
	 * @param aA The left hand element.
	 * @param aB The right hand element.
	 * @return The result of the operation.
	 */
	protected abstract T mul(T aA, T aB);
	
	/**
	 * Divide two elements.
	 * @param aA The left hand element.
	 * @param aB The right hand element.
	 * @return The result of the operation.
	 */
	protected abstract T div(T aA, T aB);
	
	/**
	 * Create a element from an integer value.
	 * @param aValue The value.
	 * @return The element.
	 */
	protected abstract T valueOf(int aValue);
	
	/**
	 * Return the smaller of two elements.
	 * @param aA The left hand element.
	 * @param aB The right hand element.
	 * @return The smallest element.
	 */
	protected abstract T min(T aA, T aB);
	
	/**
	 * Return the larger of two elements.
	 * @param aA The left hand element.
	 * @param aB The right hand element.
	 * @return The larger element.
	 */
	protected abstract T max(T aA, T aB);
	
	/**
	 * Construct a new vector with the given elements.
	 * @param aValues The element values.
	 * @return The created vector.
	 */
	protected abstract VectorCommon<T> createVector(T[] aValues);
	
	/**
	 * Create an element array of given size.
	 * @param aSize The length of array to create.
	 * @return The created array.
	 */
	protected abstract T[] createArray(int aSize);
	
	// Inherited from Object
	
	@Override
	public boolean equals(Object aOther) {
		if(! (aOther instanceof Vector<?>)) return false;
		final Vector<?> other = (Vector<?>) aOther;
		final int s = size();
		if(s != other.size()) return false;
		for(int i = 0; i < s; ++i) if(! get(i).equals(other.get(i))) return false;
		return true;
	}
	
	@Override
	public String toString() {
		final int s = size();
		String str = "[";
		for(int i = 0; i < s; ++i) {
			str += get(i).toString();
			if(i + 1 < s) str += ',';
		}
		return str + ']';
	}
	
	// Inherited from Vector

	@Override
	public Vector<T> add(T aScalar) {
		final int s = size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = add(get(i), aScalar);
		return createVector(tmp);
	}

	@Override
	public Vector<T> subtract(T aScalar) {
		final int s = size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = sub(get(i), aScalar);
		return createVector(tmp);
	}

	@Override
	public Vector<T> multiply(T aScalar) {
		final int s = size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = mul(get(i), aScalar);
		return createVector(tmp);
	}

	@Override
	public Vector<T> divide(T aScalar) {
		final int s = size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = div(get(i), aScalar);
		return createVector(tmp);
	}

	@Override
	public Vector<T> add(Vector<T> aVector) throws VectorSizeException {
		final int s = size();
		if(s != aVector.size()) throw new VectorSizeException(s, aVector.size());
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = add(get(i), aVector.get(i));
		return createVector(tmp);
	}

	@Override
	public Vector<T> subtract(Vector<T> aVector) throws VectorSizeException {
		final int s = size();
		if(s != aVector.size()) throw new VectorSizeException(s, aVector.size());
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = sub(get(i), aVector.get(i));
		return createVector(tmp);
	}

	@Override
	public Vector<T> multiply(Vector<T> aVector) throws VectorSizeException {
		final int s = size();
		if(s != aVector.size()) throw new VectorSizeException(s, aVector.size());
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = mul(get(i), aVector.get(i));
		return createVector(tmp);
	}

	@Override
	public Vector<T> divide(Vector<T> aVector) throws VectorSizeException {
		final int s = size();
		if(s != aVector.size()) throw new VectorSizeException(s, aVector.size());
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = div(get(i), aVector.get(i));
		return createVector(tmp);
	}

	@Override
	public T dotProduct(Vector<T> aVector) throws VectorSizeException {
		final int s = size();
		if(s != aVector.size()) throw new VectorSizeException(s, aVector.size());
		T tmp = valueOf(0);
		for(int i = 0; i < s; i++) tmp = add(tmp, mul(get(i), aVector.get(i)));
		return tmp;
	}

	@Override
	public Vector<T> crossProduct(Vector<T> aVector) throws VectorSizeException {
		final int sa = size();
		final int sb = aVector.size();
		if(sa != sb || sa != 3) throw new VectorSizeException(3, aVector.size());
		final T ax = get(0);
		final T ay = get(1);
		final T az = get(2);
		final T bx = aVector.get(0);
		final T by = aVector.get(1);
		final T bz = aVector.get(2);
		final T[] tmp = createArray(3);
		tmp[0] = add(mul(ay, bz), mul(az, by));
		tmp[1] = add(mul(az, bx), mul(ax, bz));
		tmp[2] = add(mul(ax, by), mul(ay, bx));
		return createVector(tmp);
	}

	@Override
	public T min() {
		final int s = size();
		T tmp = get(0);
		for(int i = 1; i < s; i++) tmp = min(tmp, get(i));
		return tmp;
	}

	@Override
	public T max() {
		final int s = size();
		T tmp = get(0);
		for(int i = 1; i < s; i++) tmp = max(tmp, get(i));
		return tmp;
	}

	@Override
	public T sum() {
		final int s = size();
		T tmp = valueOf(0);
		for(int i = 0; i < s; i++) tmp = add(tmp, get(i));
		return tmp;
	}

	@Override
	public T mean() {
		return div(sum(), valueOf(size()));
	}

	@Override
	public T median() {
		final int s = size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = get(i);
		
		Arrays.sort(tmp);
		final int i = s/2;
		if(s % 2 == 1) {
			return tmp[i];
		}else {
			return div(add(tmp[i-1], tmp[i]), valueOf(2));
		}
	}

	@Override
	public T mode() {
		final int s = size();
		T maxValue = get(0); // \TODO Test this works
		int maxCount = 0;
		 
		for(int i = 0; i < s; i++) {
			int count = 0;
			for(int j = 0; j < s; j++) {
				if(get(j) == get(i)) ++count;
			}
		        
			if(count > maxCount) {
				maxCount = count;
				maxValue = get(i);
			}
		 }

		 return maxValue;
	}

	@Override
	public T magnitudeSquared() {
		final int s = size();
		T tmp = valueOf(0);
		for(int i = 0; i < s; i++) tmp = add(tmp, mul(get(i), get(i)));
		return tmp;
	}

	@Override
	public T magnitude() {
		return sqrt(magnitudeSquared());
	}

	@Override
	public Vector<T> normalise() {
		return divide(magnitude());
	}

	@Override
	public T[] toArray() {
		final int s = size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = get(i);
		return tmp;
	}

	@Override
	public Vector<T> swizzle(int[] aIndices) {
		final int s = aIndices.length;
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = get(aIndices[i]);
		return createVector(tmp);
	}

	@Override
	public Vector<T> swizzle(Vector<Integer> aIndices) {
		final int s = aIndices.size();
		final T[] tmp = createArray(s);
		for(int i = 0; i < s; ++i) tmp[i] = get(aIndices.get(i));
		return createVector(tmp);
	}

}
