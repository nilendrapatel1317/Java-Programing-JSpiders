
7. Aggregate Operations on Specific Elements

37. Find the sum of all elements above the main diagonal in a square matrix
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `11`

38. Find the sum of all elements below the main diagonal in a square matrix
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `19`

39. Count the number of non-zero elements in the 2D array
   - Input: `[[0, 1, 2], [3, 0, 4], [5, 6, 0]]`
   - Output: `6`

40. Replace each element with the maximum element in its column
   - Input: `[[2, 5, 1], [3, 7, 4], [6, 1, 8]]`
   - Output: `[[6, 7, 8], [6, 7, 8], [6, 7, 8]]`

======================================================================================================

8. Row and Column Calculations with Conditions

41. Replace each element with the sum of elements in its row if the row sum is even
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[1, 2, 3], [15, 15, 15], [7, 8, 9]]`

42. Replace each element with the sum of elements in its column if the column sum is odd
   - Input: `[[3, 2, 3], [1, 4, 1], [1, 3, 2]]`
   - Output: `[[3, 2, 6], [5, 4, 6], [5, 3, 6]]`

43. Find the number of rows with an odd sum of elements
   - Input: `[[3, 2, 1], [4, 5, 6], [7, 8, 9]]`
   - Output: `2`

44. Find the average of all elements in each row
   - Input: `[[10, 20, 30], [5, 15, 25], [1, 2, 3]]`
   - Output: `[20, 15, 2]`

45. Find the average of all elements in each column
   - Input: `[[10, 20], [30, 40], [50, 60]]`
   - Output: `[30, 40]`

======================================================================================================

9. Transformation Based on Neighboring Elements

46. Replace each element with the sum of its four neighbors (up, down, left, right)
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[6, 8, 10], [12, 15, 18], [16, 20, 22]]`

47. Replace each element with the sum of its diagonal neighbors (top-left, top-right, bottom-left, bottom-right)
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[5, 8, 5], [14, 20, 14], [5, 8, 5]]`

48. Replace each element with the difference of the sum of its neighboring elements and itself
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[4, 6, 6], [11, 15, 11], [14, 16, 10]]`

49. Replace each element with the average of its neighboring elements
   - Input: `[[2, 4, 6], [8, 10, 12], [14, 16, 18]]`
   - Output: `[[6, 8, 8], [12, 14, 12], [14, 16, 10]]`

50. Replace boundary elements with zero and keep inner elements as they are
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[0, 0, 0], [0, 5, 0], [0, 0, 0]]`

======================================================================================================

10. Specialized Aggregation Tasks

51. Calculate the sum of all elements in the array that are divisible by a given number
   - Input: `[[10, 20, 15], [25, 30, 35]]`, divisor = 5
   - Output: `135`

52. Find the count of elements in each column that are prime numbers
   - Input: `[[11, 4, 5], [13, 6, 17], [2, 8, 19]]`
   - Output: `[3, 0, 3]`

53. Calculate the sum of elements on the secondary diagonal in a square matrix
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `15`

54. Replace elements by their row median value
   - Input: `[[1, 9, 3], [4, 6, 8], [10, 15, 12]]`
   - Output: `[[3, 3, 3], [6, 6, 6], [12, 12, 12]]`

55. Replace elements by their column median value
   - Input: `[[1, 5, 9], [3, 7, 2], [4, 6, 8]]`
   - Output: `[[3, 6, 8], [3, 6, 8], [3, 6, 8]]`

======================================================================================================

11. Rearranging and Reshaping Elements

56. Rotate the 2D array 180 degrees
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[9, 8, 7], [6, 5, 4], [3, 2, 1]]`

57. Flip each row in the 2D array left-to-right
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[3, 2, 1], [6, 5, 4], [9, 8, 7]]`

58. Flip each column in the 2D array top-to-bottom
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[7, 8, 9], [4, 5, 6], [1, 2, 3]]`

59. Shift all elements in each row to the right by one position
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[3, 1, 2], [6, 4, 5], [9, 7, 8]]`

60. Shift all elements in each column down by one position
   - Input: `[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
   - Output: `[[4, 5, 6], [7, 8, 9], [1, 2, 3]]`


