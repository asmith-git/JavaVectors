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

/**
 * Provides an interface for implementing immutable vectors.
 * @author Adam Smith
 *
 * @param <T> The element type of the vector.
 */
public interface Vector<T> {
	/**
	 * Return the length of the vector.
	 * @return The number of elemets in the vector.
	 */
	public int size();
	
	/**
	 * Replace an element at specified index.
	 * @param aIndex The index of the vector to replace.
	 * @param aValue The replacement value.
	 * @return A vector after the value replaced.
	 */
	public Vector<T> set(int aIndex, T aValue);
	
	/**
	 * Return an element at specified index.
	 * @param aIndex The index of the vector to retrieve.
	 * @return The element at the index.
	 */
	public T get(int aIndex);

	/**
	 * Add a scalar to this vector.
	 * @param aScalar The scalar value to add.
	 * @return The result of the operation.
	 */
	public Vector<T> add(T aScalar);

	/**
	 * Subtract a scalar from this vector.
	 * @param aScalar The scalar value to subtract.
	 * @return The result of the operation.
	 */
	public Vector<T> subtract(T aScalar);

	/**
	 * Multiply a scalar by this vector.
	 * @param aScalar The scalar value to multiply by.
	 * @return The result of the operation.
	 */
	public Vector<T> multiply(T aScalar);

	/**
	 * Divide a scalar by this vector.
	 * @param aScalar The scalar value to divide by.
	 * @return The result of the operation.
	 */
	public Vector<T> divide(T aScalar);

	/**
	 * Add two vectors.
	 * @param aVector The other vector.
	 * @return The result of the operation.
	 * @throws VectorSizeException Thrown when the vector lengths do not match.
	 */
	public Vector<T> add(Vector<T> aVector) throws VectorSizeException;

	/**
	 * Subtract two vectors.
	 * @param aVector The other vector.
	 * @return The result of the operation.
	 * @throws VectorSizeException Thrown when the vector lengths do not match.
	 */
	public Vector<T> subtract(Vector<T> aVector) throws VectorSizeException;

	/**
	 * Multiply two vectors.
	 * @param aVector The other vector.
	 * @return The result of the operation.
	 * @throws VectorSizeException Thrown when the vector lengths do not match.
	 */
	public Vector<T> multiply(Vector<T> aVector) throws VectorSizeException;

	/**
	 * Add Divide vectors.
	 * @param aVector The other vector.
	 * @return The result of the operation.
	 * @throws VectorSizeException Thrown when the vector lengths do not match.
	 */
	public Vector<T> divide(Vector<T> aVector) throws VectorSizeException;

	/**
	 * Calculate the dot product of two vectors.
	 * @param aVector The other vector.
	 * @return The result of the operation.
	 * @throws VectorSizeException Thrown when the vector lengths do not match.
	 */
	public T dotProduct(Vector<T> aVector) throws VectorSizeException;

	/**
	 * Calculate the cross product of two vectors.
	 * @param aVector The other vector.
	 * @return The result of the operation.
	 * @throws VectorSizeException Thrown when the vector lengths do not match.
	 */
	public Vector<T> crossProduct(Vector<T> aVector) throws VectorSizeException;

	/**
	 * Calculate the minimum value in the vector.
	 * @return The minimum value.
	 */
	public T min();

	/**
	 * Calculate the maximum value in the vector.
	 * @return The maximum value.
	 */
	public T max();

	/**
	 * Calculate the sum of all elements in the vector.
	 * @return The sum of elements.
	 */
	public T sum();

	/**
	 * Calculate the mean value of all elements in the vector.
	 * @return The mean of elements.
	 */
	public T mean();

	/**
	 * Calculate the median value of all elements in the vector.
	 * @return The mean of elements.
	 */
	public T median();

	/**
	 * Calculate the mode value of all elements in the vector.
	 * @return The mean of elements.
	 */
	public T mode();

	/**
	 * Calculate the square magnitude of the vector.
	 * @return The square magnitude.
	 */
	public T magnitudeSquared();

	/**
	 * Calculate the magnitude of the vector.
	 * @return The magnitude.
	 */
	public T magnitude();

	/**
	 * Normalise this vector.
	 * @return The unit vector.
	 */
	public Vector<T> normalise();

	/**
	 * Normalise this vector.
	 * @return The unit vector.
	 */
	public T[] toArray();
	
	/**
	 * Construct a new vector using elements contained in this one.
	 * @param aIndices The indices of this vector to duplicate.
	 * @return The resulting vector.
	 */
	public Vector<T> swizzle(int[] aIndices);
	
	/**
	 * Construct a new vector using elements contained in this one.
	 * @param aIndices The indices of this vector to duplicate.
	 * @return The resulting vector.
	 */
	public Vector<T> swizzle(Vector<Integer> aIndices);
}
