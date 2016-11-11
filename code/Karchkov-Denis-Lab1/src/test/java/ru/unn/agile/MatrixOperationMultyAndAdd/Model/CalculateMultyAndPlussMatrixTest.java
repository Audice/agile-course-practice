package ru.unn.agile.MatrixOperationMultyAndAdd.Model;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Denis on 10.11.2016.
 */
public class CalculateMultyAndPlussMatrixTest {
    private Matrix first;
    private Matrix second;
    @Test
    public void canFirstMatrixPlusSecondMatrix() {
        first = new Matrix(2, 2, new float[]{1, 1, 1, 1});
        second = new Matrix(2, 2, new float[]{2, 2, 2, 2});
        String testM = "3.0,3.0,3.0,3.0,";
        assertEquals(testM, CalcOperationMatrix.sumTwoMatrix(first, second).toString());
    }
    @Test
    public void canSumTwoMatrixWithDifferentNumberOfRows() {
        first = new Matrix(3, 2, new float[]{1, 1, 1, 1, 2, 2});
        second = new Matrix(2, 2, new float[]{2, 2, 2, 2});
        String testM = "3.0,3.0,3.0,3.0,";
        assertEquals(null, CalcOperationMatrix.sumTwoMatrix(first, second));
    }
    @Test
    public void canSumTwoMatrixWithDifferentNumberOfColumns() {
        first = new Matrix(2, 3, new float[]{1, 1, 1, 1, 2, 2});
        second = new Matrix(2, 2, new float[]{2, 2, 2, 2});
        String testM = "3.0,3.0,3.0,3.0,";
        assertEquals(null, CalcOperationMatrix.sumTwoMatrix(first, second));
    }
    @Test
    public void canSumTwoMatrixWithDifferentNumberOfColumnsAndRows() {
        first = new Matrix(3, 3, new float[]{1, 1, 1, 1, 2, 2, 1, 1, 2});
        second = new Matrix(2, 2, new float[]{2, 2, 2, 2});
        String testM = "3.0,3.0,3.0,3.0,";
        assertEquals(null, CalcOperationMatrix.sumTwoMatrix(first, second));
    }
    @Test
    public void canGetSizeArrayOfMatrix() {
        first = new Matrix(3, 2, new float[]{1, 1, 1, 1, 2, 2});
        second = new Matrix(2, 3, new float[]{1, 1, 1, 1, 2, 2});
        assertEquals(9, CalcOperationMatrix.getDimensinsForMulty(first, second));
    }
    @Test
    public void canMulty() {
        first = new Matrix(3, 2, new float[]{1, 1, 1, 1, 2, 2});
        second = new Matrix(2, 3, new float[]{1, 1, 1, 1, 2, 2});
        assertEquals(true, CalcOperationMatrix.checkDimensinsForMulty(first, second));
    }
    @Test
    public void canNotMulty() {
        first = new Matrix(3, 3, new float[]{1, 1, 1, 1, 2, 2, 1, 1, 2});
        second = new Matrix(2, 3, new float[]{1, 1, 1, 1, 2, 2});
        assertEquals(false, CalcOperationMatrix.checkDimensinsForMulty(first, second));
    }
    @Test
    public void canMultyTwoArrays() {
        first = new Matrix(2, 2, new float[]{1, 3, 4, 2});
        second = new Matrix(2, 2, new float[]{1, 2, 1, 3});
        String resultTestMatrix = "4.0,11.0,6.0,14.0,";
        assertEquals(resultTestMatrix, CalcOperationMatrix.multyTwoArray(first, second));
    }
    @Test
    public void canMultyTwoMatrix() {
        first = new Matrix(2, 2, new float[]{1, 3, 4, 2});
        second = new Matrix(2, 2, new float[]{1, 2, 1, 3});
        String result = "4.0,11.0,6.0,14.0,";
        assertEquals(result, CalcOperationMatrix.multyTwoMutrix(first, second).toString());
    }



}
