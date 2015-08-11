package com.gxwtech.rtdemo.services;

/**
 * Created by geoff on 7/1/15.
 */
public class DIATable {
    /* our pseudo-enum, because enums are a pain */
    public static final int DIA_0pt5_hour = 1;
    public static final int DIA_1_hour = 2;
    public static final int DIA_1pt5_hour = 3;
    public static final int DIA_2_hour = 4;
    public static final int DIA_2pt5_hour = 5;
    public static final int DIA_3_hour = 6;
    public static final int DIA_3pt5_hour = 7;
    public static final int DIA_4_hour = 8;
    public static final int DIA_4pt5_hour = 9;
    public static final int DIA_5_hour = 10;
    public static final int DIA_5pt5_hour = 11;
    // after 300 minutes, assume that there is no more insulin impact from an event
    static final int insulinImpactMinutesMax = 300;
    // These arrays have 300 values each, representing the PERCENT of insulin
    // still remaining at each minute after a bolus. (i.e. 5 hours, minute-by-minute)
    // Small boluses decay faster, and there are many other factors,
    // but this gives us something to work with.
    static final int[] DIA_0pt5_hour_table = {100, 100, 98, 96, 94, 91, 88, 84, 80, 76, 71, 67, 63, 58, 53, 48, 44, 39, 35, 31, 27, 23, 19, 17, 14, 13, 11, 9, 8, 7, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_1_hour_table = {100, 100, 100, 99, 98, 97, 96, 95, 94, 93, 91, 90, 88, 86, 84, 82, 80, 78, 76, 73, 71, 69, 67, 65, 63, 61, 58, 56, 53, 50, 48, 46, 44, 41, 39, 37, 35, 33, 31, 29, 27, 25, 23, 21, 19, 18, 17, 16, 14, 14, 13, 12, 11, 10, 9, 9, 8, 7, 7, 6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_1pt5_hour_table = {100, 100, 100, 100, 100, 99, 98, 98, 97, 96, 96, 95, 94, 94, 93, 91, 91, 90, 88, 88, 86, 84, 84, 82, 80, 80, 78, 76, 76, 73, 71, 71, 69, 67, 67, 65, 63, 63, 61, 58, 58, 56, 53, 53, 50, 48, 48, 46, 44, 44, 41, 39, 39, 37, 35, 35, 33, 31, 31, 29, 27, 27, 25, 23, 23, 21, 19, 19, 18, 17, 17, 16, 14, 14, 14, 13, 13, 12, 11, 11, 10, 9, 9, 9, 8, 8, 7, 7, 7, 6, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_2_hour_table = {100, 100, 100, 100, 100, 100, 99, 99, 99, 98, 98, 97, 97, 96, 96, 95, 95, 94, 94, 93, 92, 91, 90, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 59, 58, 57, 56, 55, 53, 52, 50, 49, 48, 47, 46, 45, 44, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 19, 18, 18, 17, 16, 16, 15, 14, 14, 14, 13, 13, 12, 12, 11, 11, 11, 10, 10, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_2pt5_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 98, 98, 98, 97, 97, 96, 96, 95, 95, 94, 94, 93, 93, 92, 91, 91, 90, 89, 89, 88, 87, 87, 86, 85, 84, 83, 83, 82, 81, 80, 79, 78, 77, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 31, 30, 29, 29, 28, 27, 26, 26, 25, 24, 24, 23, 22, 22, 21, 20, 19, 19, 18, 18, 17, 17, 16, 16, 15, 14, 14, 13, 13, 13, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 7, 6, 6, 6, 5, 5, 5, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_3_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 99, 98, 98, 98, 97, 97, 97, 96, 96, 96, 95, 95, 95, 94, 94, 94, 93, 93, 92, 91, 91, 90, 90, 89, 89, 88, 88, 87, 86, 86, 85, 84, 84, 83, 82, 82, 81, 80, 80, 79, 78, 78, 77, 76, 76, 74, 73, 73, 72, 71, 71, 70, 69, 69, 68, 67, 67, 66, 65, 65, 64, 63, 63, 62, 61, 61, 59, 58, 58, 57, 56, 56, 55, 53, 53, 52, 50, 50, 48, 48, 47, 46, 46, 45, 44, 44, 42, 41, 40, 39, 39, 38, 37, 37, 36, 35, 35, 34, 33, 33, 32, 31, 31, 30, 29, 29, 28, 27, 27, 26, 25, 25, 24, 23, 23, 22, 21, 21, 20, 19, 19, 19, 18, 18, 18, 17, 17, 17, 16, 16, 15, 14, 14, 14, 14, 14, 13, 13, 13, 12, 12, 11, 11, 11, 11, 10, 10, 10, 10, 9, 9, 9, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 6, 6, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    // The 2, 3, 4, and 5 hour DIA arrays below were obtained from a 522 Medtronic pump by observing the decay every minute via the pump bolus wizard.  The others were extrapolated from the observed data.
    static final int[] DIA_3pt5_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 99, 98, 98, 98, 98, 97, 97, 97, 96, 96, 96, 96, 95, 95, 95, 94, 94, 94, 94, 93, 93, 92, 91, 91, 91, 90, 90, 89, 89, 88, 88, 88, 87, 86, 86, 85, 84, 84, 84, 83, 82, 82, 81, 80, 80, 80, 79, 78, 78, 77, 76, 76, 76, 74, 73, 73, 72, 71, 71, 71, 70, 69, 69, 68, 67, 67, 67, 66, 65, 65, 64, 63, 63, 63, 62, 61, 61, 59, 58, 58, 58, 57, 56, 56, 55, 53, 53, 53, 52, 50, 50, 48, 48, 48, 47, 46, 46, 45, 44, 44, 44, 42, 41, 40, 39, 39, 39, 38, 37, 37, 36, 35, 35, 35, 34, 33, 33, 32, 31, 31, 31, 30, 29, 29, 28, 27, 27, 27, 26, 25, 25, 24, 23, 23, 23, 22, 21, 21, 20, 19, 19, 19, 19, 18, 18, 18, 17, 17, 17, 17, 16, 16, 15, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 12, 12, 11, 11, 11, 11, 11, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 6, 6, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_4_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 99, 99, 99, 98, 98, 98, 98, 97, 97, 97, 97, 96, 96, 96, 96, 95, 95, 95, 95, 94, 94, 94, 94, 93, 93, 92, 92, 91, 91, 90, 90, 90, 90, 89, 89, 88, 88, 87, 87, 86, 86, 85, 85, 84, 84, 83, 83, 82, 82, 81, 81, 81, 81, 80, 80, 79, 79, 78, 78, 77, 77, 76, 76, 74, 74, 74, 73, 73, 72, 72, 71, 71, 70, 70, 69, 69, 68, 68, 67, 67, 66, 66, 65, 65, 64, 64, 63, 63, 62, 62, 61, 61, 59, 59, 58, 58, 57, 57, 56, 56, 55, 55, 53, 53, 52, 52, 50, 50, 49, 49, 48, 48, 47, 47, 46, 46, 45, 45, 44, 44, 42, 42, 41, 41, 40, 40, 39, 39, 38, 38, 37, 37, 36, 36, 35, 35, 34, 34, 33, 33, 32, 32, 31, 31, 30, 30, 29, 29, 28, 28, 27, 27, 26, 26, 25, 25, 24, 24, 23, 23, 22, 22, 21, 21, 20, 20, 19, 19, 19, 19, 18, 18, 18, 18, 17, 17, 16, 16, 16, 16, 15, 15, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_4pt5_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 99, 99, 99, 98, 98, 98, 98, 98, 97, 97, 97, 97, 96, 96, 96, 96, 95, 95, 95, 95, 94, 94, 94, 93, 93, 92, 92, 91, 91, 91, 90, 90, 90, 89, 89, 88, 88, 87, 87, 87, 86, 86, 85, 85, 84, 84, 83, 83, 82, 82, 81, 81, 81, 81, 80, 80, 79, 79, 78, 78, 77, 77, 77, 76, 76, 75, 75, 74, 74, 73, 73, 72, 72, 71, 71, 70, 70, 69, 69, 68, 68, 67, 66, 66, 65, 65, 64, 64, 63, 63, 62, 62, 61, 61, 60, 59, 59, 58, 58, 57, 57, 56, 56, 55, 55, 54, 53, 53, 52, 52, 52, 52, 50, 50, 50, 49, 49, 48, 48, 47, 47, 46, 46, 45, 45, 44, 44, 43, 42, 42, 41, 41, 40, 40, 39, 39, 38, 38, 37, 37, 36, 36, 35, 35, 34, 34, 33, 33, 32, 32, 31, 31, 31, 30, 30, 29, 29, 29, 28, 28, 27, 27, 26, 26, 26, 25, 25, 24, 24, 24, 23, 23, 22, 22, 22, 21, 21, 20, 20, 19, 19, 19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 16, 15, 15, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 5, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_5_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 99, 99, 99, 98, 98, 98, 98, 98, 98, 98, 97, 97, 97, 97, 96, 96, 96, 96, 95, 95, 95, 95, 94, 94, 94, 94, 93, 93, 93, 92, 92, 92, 91, 91, 91, 90, 90, 90, 89, 89, 89, 88, 88, 88, 87, 87, 87, 86, 86, 85, 85, 85, 84, 84, 83, 83, 83, 82, 82, 81, 81, 80, 80, 80, 79, 79, 78, 78, 77, 77, 77, 76, 76, 75, 75, 74, 74, 73, 73, 72, 72, 71, 71, 70, 70, 69, 69, 68, 68, 67, 67, 67, 66, 65, 65, 64, 64, 64, 63, 62, 62, 61, 61, 61, 60, 59, 59, 58, 58, 58, 57, 56, 56, 55, 55, 55, 54, 53, 53, 52, 52, 52, 50, 50, 50, 49, 49, 49, 48, 47, 47, 46, 46, 46, 45, 45, 44, 44, 43, 43, 42, 42, 41, 41, 40, 40, 39, 39, 39, 38, 38, 37, 36, 36, 36, 35, 35, 35, 34, 34, 33, 33, 32, 32, 31, 31, 31, 30, 30, 30, 29, 29, 29, 28, 28, 28, 27, 27, 26, 26, 26, 25, 25, 25, 24, 24, 24, 23, 23, 23, 22, 22, 22, 22, 21, 21, 21, 20, 20, 20, 19, 19, 19, 19, 18, 18, 18, 18, 17, 17, 17, 17, 16, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 5, 5, 5, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] DIA_5pt5_hour_table = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 99, 99, 99, 99, 99, 98, 98, 98, 98, 98, 98, 98, 98, 97, 97, 97, 97, 96, 96, 96, 96, 96, 95, 95, 95, 95, 94, 94, 94, 94, 94, 93, 93, 93, 92, 92, 92, 91, 91, 91, 91, 90, 90, 90, 89, 89, 89, 88, 88, 88, 88, 87, 87, 87, 86, 86, 85, 85, 85, 84, 84, 84, 83, 83, 83, 82, 82, 81, 81, 80, 80, 80, 80, 79, 79, 78, 78, 77, 77, 77, 76, 76, 76, 75, 75, 74, 74, 73, 73, 72, 72, 71, 71, 71, 70, 70, 69, 69, 68, 68, 67, 67, 67, 67, 66, 65, 65, 64, 64, 64, 63, 63, 62, 62, 61, 61, 61, 60, 59, 59, 58, 58, 58, 58, 57, 56, 56, 55, 55, 55, 54, 53, 53, 53, 52, 52, 52, 50, 50, 50, 49, 49, 49, 48, 48, 47, 47, 46, 46, 46, 45, 45, 44, 44, 44, 43, 43, 42, 42, 41, 41, 40, 40, 39, 39, 39, 39, 38, 38, 37, 36, 36, 36, 35, 35, 35, 35, 34, 34, 33, 33, 32, 32, 31, 31, 31, 31, 30, 30, 30, 29, 29, 29, 28, 28, 28, 27, 27, 27, 26, 26, 26, 25, 25, 25, 24, 24, 24, 23, 23, 23, 23, 22, 22, 22, 22, 21, 21, 21, 20, 20, 20, 19, 19, 19, 19, 19, 18, 18, 18, 18, 17, 17, 17, 17, 17, 16, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int mFlavor;

    public DIATable() {
        mFlavor = DIA_3_hour; // default, shouldn't ever be used.
    }

    public DIATable(int flavor) {
        mFlavor = flavor;
    }

    static final int[] getTable(int which) {
        switch (which) {
            case DIA_0pt5_hour:
                return DIA_0pt5_hour_table;
            case DIA_1_hour:
                return DIA_1_hour_table;
            case DIA_1pt5_hour:
                return DIA_1pt5_hour_table;
            case DIA_2_hour:
                return DIA_2_hour_table;
            case DIA_2pt5_hour:
                return DIA_2pt5_hour_table;
            case DIA_3_hour:
                return DIA_3_hour_table;
            case DIA_3pt5_hour:
                return DIA_3pt5_hour_table;
            case DIA_4_hour:
                return DIA_4_hour_table;
            case DIA_4pt5_hour:
                return DIA_4pt5_hour_table;
            case DIA_5_hour:
                return DIA_5_hour_table;
            case DIA_5pt5_hour:
                return DIA_5pt5_hour_table;

            // this will probably cause a crash, if used, but it shuts up the compiler.
            default:
                final int[] default_table = {};
                return default_table;
        }
    }

    static final String getNameForTable(int which) {
        switch (which) {
            case DIA_0pt5_hour:
                return "DIA 30 minutes";
            case DIA_1_hour:
                return "DIA 60 minutes";
            case DIA_1pt5_hour:
                return "DIA 90 minutes";
            case DIA_2_hour:
                return "DIA 2 hours";
            case DIA_2pt5_hour:
                return "DIA 2.5 hours";
            case DIA_3_hour:
                return "DIA 3 hours";
            case DIA_3pt5_hour:
                return "DIA 3.5 hours";
            case DIA_4_hour:
                return "DIA 4 hours";
            case DIA_4pt5_hour:
                return "DIA 4.5 hours";
            case DIA_5_hour:
                return "DIA 5 hours";
            case DIA_5pt5_hour:
                return "DIA 5.5 hours";
            default:
                return "DIA UNKNOWN";
        }
    }

    public static int insulinPercentRemaining(int elapsed_minutes, int which) {
        int rval;
        if (elapsed_minutes < 0) {
            rval = 100;
        } else if (elapsed_minutes > insulinImpactMinutesMax) {
            //all tables are zero after 300 minutes
            rval = 0;
        } else {
            rval = getTable(which)[elapsed_minutes];
        }
        return rval;
    }

    public String toString() {
        return getNameForTable(mFlavor);
    }

    public int insulinPercentRemaining(int elapsed_minutes) {
        return insulinPercentRemaining(elapsed_minutes, mFlavor);
    }

    final int[] getTable() {
        return getTable(mFlavor);
    }
}
