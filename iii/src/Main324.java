import java.util.Scanner;

/**
*	324 - Factorial Frequencies
*
*
*	Submision:	9965882
*	Date:		2012-04-07 12:33:20
*	Runtime:	0.196
*	Ranking:	4986
*/
public class Main324 {
	static int[][] facts = { { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 0 }, { 2, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
			{ 2, 0, 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 0, 0, 1, 0, 2, 0 },
			{ 2, 0, 1, 1, 0, 0, 1, 0, 2, 0 }, { 2, 1, 0, 1, 0, 0, 1, 0, 1, 2 },
			{ 4, 1, 0, 0, 1, 0, 1, 1, 0, 1 }, { 4, 0, 3, 0, 0, 0, 1, 1, 1, 0 },
			{ 2, 2, 2, 0, 0, 0, 0, 2, 2, 1 }, { 4, 1, 0, 2, 1, 0, 2, 2, 1, 0 },
			{ 4, 0, 3, 0, 0, 0, 0, 1, 4, 2 }, { 4, 0, 1, 1, 1, 2, 2, 1, 2, 1 },
			{ 5, 0, 2, 2, 1, 1, 1, 3, 1, 0 }, { 6, 3, 2, 1, 2, 1, 1, 0, 2, 0 },
			{ 7, 1, 3, 1, 2, 0, 2, 1, 1, 1 }, { 7, 3, 1, 0, 3, 1, 0, 2, 0, 3 },
			{ 8, 2, 2, 0, 1, 0, 2, 6, 1, 0 }, { 5, 1, 2, 1, 2, 2, 3, 2, 4, 1 },
			{ 6, 1, 2, 5, 4, 0, 2, 1, 1, 2 }, { 9, 4, 1, 3, 2, 3, 0, 0, 2, 2 },
			{ 8, 3, 2, 2, 3, 3, 4, 0, 1, 1 }, { 9, 3, 1, 1, 2, 2, 3, 1, 6, 1 },
			{ 10, 4, 0, 3, 4, 2, 2, 1, 4, 0 },
			{ 7, 4, 0, 3, 3, 2, 3, 3, 2, 4 }, { 9, 3, 4, 2, 1, 4, 3, 0, 5, 2 },
			{ 7, 2, 7, 1, 1, 3, 2, 4, 6, 1 },
			{ 10, 5, 3, 7, 0, 1, 5, 1, 2, 2 },
			{ 8, 7, 1, 2, 3, 2, 3, 1, 8, 2 },
			{ 11, 2, 4, 3, 4, 2, 4, 2, 2, 5 },
			{ 9, 4, 3, 7, 3, 2, 7, 2, 1, 3 },
			{ 10, 4, 3, 4, 3, 2, 2, 4, 3, 7 },
			{ 12, 4, 3, 5, 3, 5, 3, 3, 2, 4 },
			{ 16, 7, 7, 1, 3, 1, 5, 4, 0, 1 },
			{ 12, 3, 4, 5, 3, 2, 2, 4, 7, 5 },
			{ 9, 6, 5, 3, 4, 5, 3, 4, 4, 5 },
			{ 15, 6, 4, 5, 3, 6, 6, 3, 2, 0 },
			{ 13, 6, 3, 3, 6, 5, 5, 3, 4, 4 },
			{ 13, 4, 4, 9, 2, 7, 6, 4, 2, 2 },
			{ 12, 6, 4, 3, 5, 5, 5, 4, 9, 2 },
			{ 13, 7, 4, 5, 4, 5, 8, 4, 3, 4 },
			{ 16, 4, 8, 1, 3, 8, 4, 1, 7, 6 },
			{ 11, 10, 6, 5, 3, 5, 7, 2, 4, 7 },
			{ 14, 4, 6, 7, 4, 6, 6, 8, 4, 3 },
			{ 14, 5, 10, 6, 3, 5, 6, 5, 7, 2 },
			{ 19, 7, 3, 6, 7, 2, 9, 5, 5, 2 },
			{ 18, 10, 10, 6, 3, 4, 5, 3, 5, 3 },
			{ 18, 3, 3, 4, 5, 7, 8, 8, 9, 3 },
			{ 17, 2, 6, 9, 7, 3, 7, 5, 8, 6 },
			{ 18, 5, 9, 8, 6, 3, 3, 7, 9, 4 },
			{ 18, 5, 6, 5, 6, 11, 9, 4, 4, 6 },
			{ 17, 4, 1, 3, 13, 5, 6, 9, 11, 6 },
			{ 20, 7, 9, 4, 8, 6, 7, 4, 7, 5 },
			{ 17, 10, 10, 5, 8, 5, 4, 4, 10, 6 },
			{ 19, 6, 6, 8, 7, 5, 6, 7, 9, 8 },
			{ 19, 8, 9, 8, 10, 3, 8, 7, 4, 6 },
			{ 26, 3, 10, 4, 4, 7, 6, 6, 11, 7 },
			{ 20, 8, 13, 8, 4, 6, 6, 8, 7, 6 },
			{ 21, 9, 8, 5, 8, 4, 11, 8, 7, 7 },
			{ 20, 12, 6, 9, 10, 7, 6, 3, 12, 5 },
			{ 20, 5, 11, 7, 8, 10, 8, 9, 7, 6 },
			{ 23, 5, 8, 7, 16, 3, 8, 8, 9, 6 },
			{ 22, 8, 8, 6, 10, 7, 11, 6, 9, 8 },
			{ 25, 11, 8, 9, 7, 8, 6, 8, 7, 8 },
			{ 21, 9, 14, 10, 13, 5, 4, 8, 8, 7 },
			{ 20, 7, 7, 5, 6, 10, 11, 9, 14, 12 },
			{ 25, 6, 8, 7, 5, 7, 11, 10, 18, 5 },
			{ 23, 6, 10, 8, 10, 3, 10, 12, 15, 7 },
			{ 35, 16, 8, 6, 7, 7, 6, 7, 9, 5 },
			{ 23, 13, 14, 10, 7, 13, 5, 7, 9, 7 },
			{ 25, 9, 9, 7, 13, 9, 9, 9, 10, 10 },
			{ 24, 7, 12, 11, 11, 10, 8, 9, 8, 12 },
			{ 32, 7, 10, 7, 11, 6, 9, 7, 18, 7 },
			{ 25, 11, 16, 9, 10, 9, 8, 10, 12, 6 },
			{ 29, 15, 8, 10, 4, 7, 11, 10, 14, 9 },
			{ 27, 8, 12, 8, 13, 14, 10, 9, 13, 5 },
			{ 27, 9, 9, 8, 13, 13, 8, 14, 8, 12 },
			{ 28, 13, 5, 15, 16, 1, 11, 11, 10, 13 },
			{ 30, 10, 9, 10, 10, 12, 12, 12, 8, 12 },
			{ 27, 15, 12, 13, 8, 8, 13, 9, 12, 10 },
			{ 36, 13, 14, 8, 15, 13, 9, 7, 5, 9 },
			{ 28, 8, 17, 10, 14, 13, 11, 13, 8, 9 },
			{ 27, 14, 16, 13, 10, 11, 7, 17, 8, 10 },
			{ 28, 14, 12, 8, 18, 10, 12, 2, 18, 13 },
			{ 34, 12, 9, 12, 6, 10, 15, 11, 10, 18 },
			{ 28, 11, 10, 10, 13, 12, 15, 12, 14, 14 },
			{ 29, 12, 8, 6, 12, 17, 17, 19, 9, 12 },
			{ 29, 13, 8, 18, 17, 17, 8, 15, 11, 7 },
			{ 32, 16, 17, 12, 12, 14, 11, 12, 12, 7 },
			{ 37, 11, 11, 12, 12, 15, 16, 10, 16, 7 },
			{ 32, 8, 19, 15, 12, 12, 11, 15, 10, 15 },
			{ 36, 9, 7, 9, 16, 11, 11, 15, 16, 20 },
			{ 26, 17, 13, 12, 11, 11, 13, 16, 17, 16 },
			{ 35, 6, 16, 10, 16, 9, 14, 19, 16, 13 },
			{ 28, 15, 19, 10, 10, 14, 19, 7, 14, 20 },
			{ 30, 15, 19, 10, 10, 14, 19, 7, 14, 20 },
			{ 35, 10, 14, 18, 14, 13, 14, 12, 12, 18 },
			{ 37, 12, 9, 12, 17, 27, 16, 6, 11, 15 },
			{ 36, 16, 17, 11, 18, 15, 11, 9, 17, 14 },
			{ 33, 13, 13, 12, 16, 14, 11, 25, 18, 12 },
			{ 45, 11, 14, 16, 11, 11, 15, 15, 12, 19 },
			{ 36, 11, 19, 20, 22, 8, 15, 15, 18, 7 },
			{ 42, 19, 15, 22, 11, 17, 14, 10, 11, 12 },
			{ 41, 17, 12, 16, 17, 15, 12, 12, 19, 14 },
			{ 39, 13, 21, 23, 17, 10, 8, 15, 17, 14 },
			{ 38, 18, 23, 13, 18, 13, 12, 19, 13, 12 },
			{ 39, 17, 12, 15, 18, 20, 19, 19, 10, 12 },
			{ 38, 10, 17, 17, 15, 15, 14, 22, 18, 17 },
			{ 35, 26, 24, 14, 15, 14, 17, 15, 12, 13 },
			{ 47, 19, 16, 19, 19, 18, 11, 8, 18, 12 },
			{ 51, 19, 18, 18, 12, 21, 9, 12, 13, 16 },
			{ 44, 23, 14, 18, 8, 16, 19, 13, 17, 19 },
			{ 47, 15, 14, 14, 25, 11, 21, 14, 14, 18 },
			{ 40, 13, 24, 21, 17, 14, 17, 13, 23, 13 },
			{ 42, 16, 11, 18, 29, 17, 12, 20, 19, 13 },
			{ 45, 19, 15, 16, 15, 21, 16, 11, 21, 20 },
			{ 47, 15, 20, 17, 18, 11, 18, 23, 16, 16 },
			{ 52, 14, 19, 15, 24, 18, 15, 18, 13, 15 },
			{ 42, 25, 24, 16, 15, 16, 21, 14, 17, 16 },
			{ 53, 25, 12, 11, 22, 20, 21, 17, 11, 16 },
			{ 47, 16, 11, 20, 16, 24, 16, 19, 25, 16 },
			{ 52, 19, 15, 22, 16, 15, 13, 25, 21, 14 },
			{ 54, 14, 17, 13, 11, 14, 25, 29, 14, 23 },
			{ 50, 11, 21, 21, 18, 25, 21, 18, 16, 15 },
			{ 48, 22, 23, 17, 20, 14, 23, 14, 19, 18 },
			{ 51, 14, 21, 14, 23, 24, 16, 20, 15, 22 },
			{ 46, 16, 15, 17, 21, 19, 26, 21, 21, 20 },
			{ 54, 20, 19, 14, 19, 15, 27, 18, 17, 22 },
			{ 61, 22, 17, 15, 12, 21, 17, 21, 26, 15 },
			{ 56, 21, 19, 22, 27, 12, 15, 14, 22, 21 },
			{ 57, 20, 18, 23, 25, 21, 19, 19, 19, 10 },
			{ 53, 24, 24, 16, 19, 22, 18, 19, 25, 13 },
			{ 49, 19, 28, 23, 13, 16, 18, 25, 28, 16 },
			{ 54, 19, 20, 15, 21, 16, 23, 22, 29, 18 },
			{ 57, 24, 14, 15, 14, 19, 27, 16, 18, 35 },
			{ 60, 24, 11, 17, 20, 20, 21, 24, 22, 23 },
			{ 53, 26, 24, 15, 18, 18, 16, 29, 22, 23 },
			{ 56, 20, 20, 12, 22, 14, 20, 29, 28, 25 },
			{ 53, 28, 13, 26, 23, 26, 25, 17, 20, 17 },
			{ 58, 16, 18, 26, 20, 19, 16, 27, 23, 27 },
			{ 57, 27, 21, 16, 25, 21, 19, 20, 18, 28 },
			{ 57, 22, 27, 16, 18, 22, 20, 20, 26, 27 },
			{ 57, 27, 28, 20, 20, 23, 19, 21, 23, 19 },
			{ 50, 25, 23, 26, 23, 26, 21, 24, 26, 15 },
			{ 52, 10, 25, 28, 23, 25, 21, 22, 29, 26 },
			{ 51, 20, 25, 19, 30, 32, 21, 22, 21, 22 },
			{ 60, 27, 26, 24, 21, 21, 19, 20, 27, 20 },
			{ 61, 24, 20, 30, 21, 29, 23, 26, 19, 15 },
			{ 62, 31, 20, 28, 21, 19, 29, 15, 19, 26 },
			{ 68, 22, 18, 18, 24, 22, 28, 22, 28, 22 },
			{ 57, 24, 24, 30, 27, 20, 27, 24, 16, 25 },
			{ 62, 22, 24, 24, 18, 24, 28, 24, 22, 28 },
			{ 54, 22, 28, 21, 26, 30, 23, 30, 23, 22 },
			{ 60, 25, 19, 31, 22, 20, 23, 24, 29, 28 },
			{ 59, 28, 30, 26, 20, 22, 29, 16, 30, 23 },
			{ 63, 29, 24, 27, 24, 19, 22, 23, 21, 33 },
			{ 66, 23, 26, 19, 30, 25, 15, 26, 28, 29 },
			{ 70, 26, 29, 19, 25, 20, 17, 25, 24, 35 },
			{ 68, 24, 27, 23, 22, 23, 30, 26, 19, 30 },
			{ 63, 28, 37, 24, 22, 21, 26, 27, 28, 18 },
			{ 68, 25, 22, 26, 32, 33, 23, 22, 21, 24 },
			{ 66, 26, 24, 25, 20, 23, 35, 27, 23, 29 },
			{ 70, 42, 23, 19, 29, 24, 22, 25, 22, 25 },
			{ 63, 28, 25, 21, 29, 29, 35, 27, 27, 19 },
			{ 70, 28, 24, 20, 29, 28, 25, 26, 31, 24 },
			{ 68, 29, 31, 20, 22, 32, 31, 26, 20, 28 },
			{ 66, 32, 25, 21, 22, 30, 27, 26, 34, 27 },
			{ 73, 27, 20, 32, 22, 30, 23, 31, 27, 27 },
			{ 66, 22, 40, 30, 26, 24, 29, 28, 21, 28 },
			{ 67, 23, 34, 30, 22, 30, 40, 22, 30, 18 },
			{ 72, 27, 23, 32, 28, 18, 48, 19, 27, 25 },
			{ 75, 34, 22, 33, 24, 28, 21, 22, 36, 26 },
			{ 70, 19, 30, 38, 27, 29, 20, 30, 38, 22 },
			{ 60, 32, 31, 24, 21, 25, 34, 29, 35, 34 },
			{ 74, 26, 28, 32, 34, 18, 32, 34, 24, 26 },
			{ 75, 30, 16, 39, 27, 26, 32, 20, 29, 36 },
			{ 66, 27, 31, 36, 31, 22, 35, 20, 34, 30 },
			{ 79, 31, 23, 26, 36, 22, 30, 29, 27, 31 },
			{ 69, 25, 37, 37, 32, 21, 25, 37, 24, 30 },
			{ 75, 18, 40, 27, 36, 29, 28, 27, 33, 26 },
			{ 81, 33, 31, 21, 33, 34, 29, 29, 27, 23 },
			{ 83, 27, 31, 32, 26, 25, 34, 27, 33, 25 },
			{ 67, 28, 37, 33, 27, 32, 31, 36, 25, 30 },
			{ 73, 32, 22, 24, 39, 33, 27, 34, 23, 41 },
			{ 72, 34, 28, 32, 31, 26, 36, 30, 29, 32 },
			{ 74, 27, 35, 29, 40, 36, 33, 24, 26, 28 },
			{ 82, 23, 32, 29, 27, 30, 35, 27, 39, 31 },
			{ 80, 27, 26, 35, 32, 39, 29, 27, 24, 38 },
			{ 70, 30, 32, 42, 24, 35, 18, 41, 31, 36 },
			{ 87, 24, 40, 28, 31, 34, 21, 24, 38, 35 },
			{ 81, 29, 33, 31, 30, 39, 36, 24, 23, 38 },
			{ 80, 37, 36, 28, 26, 23, 36, 36, 34, 30 },
			{ 76, 21, 29, 39, 34, 31, 40, 37, 32, 30 },
			{ 80, 33, 41, 29, 35, 38, 30, 25, 32, 28 },
			{ 71, 53, 36, 30, 25, 29, 42, 24, 34, 29 },
			{ 76, 26, 54, 41, 35, 25, 29, 35, 23, 31 },
			{ 80, 46, 43, 36, 33, 24, 31, 32, 29, 24 },
			{ 82, 34, 39, 40, 39, 27, 32, 35, 24, 28 },
			{ 91, 27, 36, 30, 29, 42, 31, 31, 27, 38 },
			{ 78, 32, 43, 37, 33, 33, 31, 36, 28, 34 },
			{ 71, 33, 46, 38, 27, 45, 36, 21, 35, 35 },
			{ 78, 32, 36, 30, 33, 37, 39, 30, 37, 37 },
			{ 74, 38, 34, 35, 25, 26, 43, 32, 41, 44 },
			{ 82, 31, 37, 30, 32, 33, 41, 32, 40, 36 },
			{ 85, 36, 38, 36, 31, 33, 38, 32, 34, 33 },
			{ 83, 38, 40, 28, 34, 37, 39, 38, 33, 29 },
			{ 89, 41, 35, 32, 39, 25, 44, 38, 28, 30 },
			{ 85, 33, 37, 30, 39, 36, 35, 44, 34, 30 },
			{ 95, 41, 31, 23, 33, 36, 53, 45, 28, 21 },
			{ 82, 26, 35, 40, 35, 40, 45, 32, 33, 40 },
			{ 81, 38, 35, 36, 32, 30, 48, 30, 38, 42 },
			{ 102, 37, 27, 38, 32, 33, 41, 30, 36, 37 },
			{ 78, 37, 41, 41, 40, 33, 37, 42, 39, 27 },
			{ 85, 42, 39, 38, 26, 32, 42, 34, 34, 45 },
			{ 96, 46, 34, 36, 23, 45, 42, 31, 36, 31 },
			{ 85, 29, 39, 36, 37, 48, 38, 45, 30, 35 },
			{ 90, 40, 28, 33, 37, 45, 40, 40, 35, 36 },
			{ 93, 38, 35, 26, 43, 54, 38, 25, 41, 34 },
			{ 85, 34, 40, 46, 43, 36, 36, 25, 50, 34 },
			{ 81, 35, 24, 46, 47, 45, 41, 42, 31, 39 },
			{ 95, 30, 37, 38, 47, 32, 41, 36, 38, 40 },
			{ 87, 40, 43, 43, 29, 44, 34, 38, 35, 43 },
			{ 102, 35, 32, 48, 48, 35, 33, 33, 31, 41 },
			{ 99, 40, 43, 39, 38, 39, 37, 50, 28, 28 },
			{ 96, 39, 37, 43, 45, 35, 33, 41, 47, 27 },
			{ 89, 38, 43, 39, 45, 51, 30, 31, 38, 41 },
			{ 89, 50, 45, 46, 44, 35, 40, 28, 39, 32 },
			{ 98, 39, 41, 33, 33, 39, 41, 37, 44, 45 },
			{ 93, 42, 48, 41, 46, 31, 41, 32, 44, 34 },
			{ 88, 46, 30, 48, 32, 37, 52, 32, 37, 53 },
			{ 93, 47, 41, 40, 42, 45, 36, 46, 37, 30 },
			{ 94, 43, 48, 43, 43, 41, 35, 39, 39, 35 },
			{ 91, 37, 45, 37, 38, 42, 42, 44, 44, 42 },
			{ 100, 43, 35, 44, 38, 40, 40, 47, 41, 36 },
			{ 96, 40, 40, 44, 48, 50, 36, 32, 45, 36 },
			{ 99, 40, 43, 28, 32, 48, 49, 37, 42, 51 },
			{ 104, 33, 34, 38, 51, 44, 41, 44, 41, 41 },
			{ 100, 33, 33, 45, 36, 43, 38, 54, 56, 36 },
			{ 94, 46, 35, 30, 42, 45, 42, 50, 49, 43 },
			{ 102, 40, 52, 33, 39, 56, 40, 35, 39, 43 },
			{ 103, 40, 38, 39, 38, 44, 46, 46, 42, 45 },
			{ 97, 51, 49, 48, 45, 32, 44, 39, 45, 33 },
			{ 101, 57, 41, 37, 44, 40, 44, 39, 38, 45 },
			{ 100, 42, 42, 44, 47, 50, 36, 38, 44, 45 },
			{ 105, 49, 54, 41, 33, 42, 43, 42, 31, 51 },
			{ 103, 43, 56, 40, 34, 39, 32, 53, 53, 40 },
			{ 105, 51, 33, 47, 43, 47, 43, 42, 47, 37 },
			{ 104, 44, 49, 43, 45, 47, 44, 44, 43, 35 },
			{ 99, 41, 43, 46, 54, 34, 48, 47, 35, 53 },
			{ 114, 44, 40, 45, 53, 40, 41, 38, 49, 39 },
			{ 110, 42, 54, 46, 42, 47, 50, 39, 40, 35 },
			{ 104, 44, 50, 39, 42, 46, 53, 51, 47, 31 },
			{ 120, 44, 43, 45, 42, 42, 40, 42, 52, 40 },
			{ 120, 62, 42, 37, 47, 48, 39, 35, 39, 43 },
			{ 103, 65, 45, 45, 43, 37, 44, 46, 45, 42 },
			{ 112, 45, 48, 64, 36, 45, 42, 36, 45, 44 },
			{ 116, 39, 33, 50, 41, 52, 50, 52, 38, 48 },
			{ 104, 59, 44, 38, 51, 33, 43, 50, 50, 50 },
			{ 106, 53, 47, 40, 53, 37, 47, 57, 40, 44 },
			{ 121, 49, 49, 46, 43, 55, 43, 45, 36, 40 },
			{ 110, 45, 41, 53, 44, 50, 45, 49, 47, 45 },
			{ 115, 49, 46, 38, 40, 45, 56, 47, 45, 51 },
			{ 109, 56, 44, 51, 56, 41, 50, 45, 36, 46 },
			{ 108, 44, 49, 45, 56, 46, 52, 47, 40, 49 },
			{ 115, 45, 58, 45, 47, 50, 40, 38, 43, 58 },
			{ 103, 50, 51, 51, 47, 49, 59, 37, 46, 48 },
			{ 117, 37, 55, 37, 48, 66, 46, 41, 47, 50 },
			{ 105, 57, 50, 53, 51, 51, 44, 37, 47, 51 },
			{ 133, 54, 43, 53, 62, 38, 43, 40, 42, 41 },
			{ 128, 48, 39, 50, 59, 51, 50, 33, 47, 46 },
			{ 113, 46, 51, 45, 59, 56, 41, 50, 45, 48 },
			{ 125, 60, 48, 51, 58, 52, 33, 39, 39, 51 },
			{ 108, 47, 56, 44, 44, 37, 63, 45, 58, 56 },
			{ 102, 47, 54, 44, 42, 54, 57, 49, 51, 61 },
			{ 122, 44, 56, 51, 52, 33, 53, 43, 59, 50 },
			{ 115, 46, 54, 48, 59, 50, 47, 53, 42, 52 },
			{ 109, 53, 28, 59, 46, 63, 53, 51, 47, 59 },
			{ 111, 51, 48, 48, 52, 47, 52, 52, 60, 50 },
			{ 109, 44, 45, 59, 58, 48, 60, 41, 62, 47 },
			{ 120, 52, 58, 47, 64, 46, 37, 49, 46, 57 },
			{ 135, 43, 42, 56, 47, 42, 46, 55, 58, 54 },
			{ 126, 43, 60, 40, 43, 53, 55, 64, 49, 47 },
			{ 116, 52, 53, 45, 47, 55, 43, 64, 49, 59 },
			{ 116, 54, 50, 56, 49, 51, 59, 51, 53, 46 },
			{ 117, 44, 51, 59, 49, 55, 57, 48, 59, 49 },
			{ 124, 59, 51, 49, 54, 48, 49, 49, 51, 56 },
			{ 116, 64, 41, 56, 57, 53, 65, 43, 49, 49 },
			{ 127, 51, 48, 52, 52, 42, 53, 53, 51, 66 },
			{ 120, 57, 63, 49, 44, 56, 47, 49, 43, 70 },
			{ 125, 55, 46, 58, 53, 52, 56, 51, 64, 40 },
			{ 105, 55, 59, 55, 53, 53, 51, 44, 70, 58 },
			{ 122, 57, 47, 46, 54, 50, 54, 52, 66, 57 },
			{ 132, 55, 53, 60, 49, 46, 45, 54, 47, 67 },
			{ 125, 70, 43, 53, 59, 57, 48, 47, 49, 59 },
			{ 123, 59, 56, 51, 51, 56, 45, 57, 64, 51 },
			{ 121, 42, 66, 54, 53, 59, 66, 54, 51, 49 },
			{ 128, 57, 57, 57, 54, 59, 57, 53, 45, 50 },
			{ 124, 55, 51, 63, 54, 46, 47, 55, 73, 52 },
			{ 115, 62, 60, 50, 59, 62, 44, 62, 55, 53 },
			{ 142, 51, 59, 48, 58, 52, 64, 54, 46, 51 },
			{ 131, 44, 60, 59, 54, 48, 54, 66, 53, 58 },
			{ 130, 70, 59, 50, 44, 53, 57, 57, 53, 57 },
			{ 123, 52, 66, 67, 56, 59, 52, 56, 51, 50 },
			{ 133, 60, 57, 72, 60, 50, 43, 50, 48, 62 },
			{ 142, 64, 55, 55, 56, 62, 44, 50, 56, 53 },
			{ 117, 60, 58, 54, 42, 51, 81, 67, 60, 50 },
			{ 136, 59, 51, 59, 54, 52, 60, 50, 57, 64 },
			{ 136, 64, 59, 50, 40, 47, 70, 71, 51, 57 },
			{ 129, 58, 60, 65, 70, 53, 52, 58, 52, 50 },
			{ 134, 57, 60, 57, 48, 54, 62, 63, 57, 58 },
			{ 125, 64, 71, 59, 56, 50, 60, 56, 52, 59 },
			{ 134, 46, 57, 54, 80, 57, 55, 54, 60, 58 },
			{ 129, 59, 67, 59, 63, 53, 56, 62, 64, 45 },
			{ 136, 58, 54, 58, 55, 60, 54, 67, 60, 58 },
			{ 128, 59, 75, 60, 47, 67, 73, 48, 48, 57 },
			{ 133, 48, 59, 62, 63, 63, 63, 51, 61, 62 },
			{ 138, 63, 49, 57, 64, 65, 66, 57, 52, 56 },
			{ 128, 55, 54, 58, 60, 53, 66, 60, 74, 62 },
			{ 141, 57, 66, 54, 62, 61, 54, 66, 52, 59 },
			{ 142, 80, 61, 62, 44, 52, 51, 56, 55, 72 },
			{ 139, 46, 67, 65, 63, 49, 68, 71, 58, 51 },
			{ 140, 58, 56, 55, 59, 64, 75, 52, 67, 54 },
			{ 155, 50, 56, 74, 53, 46, 60, 59, 78, 51 },
			{ 140, 55, 67, 66, 49, 72, 62, 53, 57, 64 },
			{ 145, 55, 65, 61, 48, 70, 55, 59, 60, 69 },
			{ 154, 58, 53, 54, 71, 76, 55, 64, 58, 47 },
			{ 133, 53, 64, 70, 69, 62, 64, 65, 52, 60 },
			{ 144, 61, 48, 62, 62, 54, 62, 66, 66, 70 },
			{ 137, 53, 63, 56, 71, 70, 61, 51, 66, 70 },
			{ 135, 70, 53, 59, 59, 67, 71, 62, 65, 59 },
			{ 150, 63, 54, 62, 57, 73, 53, 62, 73, 56 },
			{ 137, 69, 48, 59, 65, 58, 71, 60, 73, 65 },
			{ 159, 52, 59, 61, 63, 63, 58, 63, 62, 68 },
			{ 142, 63, 66, 54, 57, 50, 67, 72, 67, 72 },
			{ 155, 69, 54, 58, 54, 65, 71, 63, 58, 66 },
			{ 147, 75, 65, 74, 59, 53, 57, 49, 83, 53 },
			{ 137, 62, 55, 66, 58, 71, 74, 67, 61, 67 },
			{ 155, 56, 61, 72, 59, 68, 63, 59, 69, 58 },
			{ 144, 63, 70, 59, 75, 64, 60, 75, 58, 55 },
			{ 150, 66, 66, 77, 56, 56, 69, 50, 68, 67 },
			{ 160, 53, 60, 62, 57, 80, 55, 66, 78, 57 },
			{ 144, 77, 65, 68, 67, 72, 57, 70, 53, 57 },
			{ 159, 59, 65, 68, 73, 60, 67, 61, 59, 62 },
			{ 149, 60, 62, 61, 67, 68, 74, 66, 72, 57 },
			{ 147, 80, 62, 61, 64, 61, 62, 56, 83, 62 },
			{ 143, 73, 59, 67, 76, 71, 61, 62, 60, 69 },
			{ 158, 65, 65, 71, 74, 65, 60, 62, 68, 55 },
			{ 147, 58, 61, 56, 65, 69, 85, 59, 67, 79 },
			{ 166, 72, 69, 64, 59, 74, 67, 49, 61, 67 },
			{ 163, 60, 63, 67, 81, 70, 66, 52, 57, 72 },
			{ 153, 54, 74, 65, 71, 55, 70, 65, 76, 70 },
			{ 158, 60, 63, 67, 89, 71, 66, 60, 60, 62 },
			{ 172, 57, 65, 58, 70, 68, 65, 78, 63, 62 },
			{ 162, 66, 64, 76, 61, 74, 71, 50, 66, 71 },
			{ 150, 73, 72, 58, 71, 52, 77, 68, 73, 70 },
			{ 166, 55, 62, 75, 73, 73, 65, 65, 70, 62 },
			{ 157, 62, 71, 80, 69, 72, 66, 71, 65, 56 },
			{ 161, 67, 72, 57, 72, 69, 66, 77, 60, 70 },
			{ 155, 65, 83, 77, 58, 57, 73, 75, 61, 70 },
			{ 158, 69, 61, 74, 74, 74, 59, 70, 69, 68 },
			{ 166, 76, 54, 64, 72, 69, 69, 60, 70, 79 },
			{ 160, 93, 58, 60, 74, 81, 58, 64, 59, 74 } };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		while ((n = input.nextInt()) != 0) {
			System.out.printf("%d! --\n", n);
			n--;
			System.out.printf(
					"   (0)%5d    (1)%5d    (2)%5d    (3)%5d    (4)%5d\n",
					facts[n][0], facts[n][1], facts[n][2], facts[n][3],
					facts[n][4]);
			System.out.printf(
					"   (5)%5d    (6)%5d    (7)%5d    (8)%5d    (9)%5d\n",
					facts[n][5], facts[n][6], facts[n][7], facts[n][8],
					facts[n][9]);
		}
		// TODO Auto-generated method stub

	}

}
