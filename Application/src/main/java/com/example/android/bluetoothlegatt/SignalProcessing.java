package com.example.android.bluetoothlegatt;

import java.util.ArrayList;

public class SignalProcessing {



    ArrayList<Float> W_filter = new ArrayList<Float>();
    ArrayList<Float> W_Window = new ArrayList<Float>();

    float y_diff_dataPoint=0;
    float y_filtered_dataPoint=0;
    int updated_data_array[]={0};

    private int[] data_Points_array(int data_Point, int array_size){
        int index= array_size-1;
        for (int counter=0; counter<=index; counter++){
            if (counter==index){
                updated_data_array[index]=data_Point;
            }else {
                updated_data_array[counter]=updated_data_array[counter+1];
            }
        }
        return updated_data_array;
    }


    private ArrayList FIR_Filters_HIGH_LOW(String Filter_Type, int Sampling_Freq, int CutOff_Freq, long Filter_Order){

        float ft = CutOff_Freq/Sampling_Freq;//TODO: check the condition if sampling freq = 0
        float Filter_Function=0;

        if (Filter_Type == "LowPass"){
            for (int n=0; n <= Filter_Order; n++){
                if (n != (Filter_Order/2)){
                    Filter_Function = (float) ((Math.sin(2*Math.PI*ft*(n-Filter_Order/2)))/(Math.PI*(n-Filter_Order/2)));
                }else if (n == Filter_Order/2){
                    Filter_Function = 2*ft;
                }
                W_filter.add(Filter_Function);
            }
        }else if (Filter_Type == "HighPass"){

            for (int n=0; n <= Filter_Order; n++){
                if (n != (Filter_Order/2)){
                    Filter_Function = (float) (-1*( (Math.sin(2*Math.PI*ft*(n-Filter_Order/2)))/(Math.PI*(n-Filter_Order/2))));
                }else if (n == Filter_Order/2){
                    Filter_Function = 1 - 2*ft;
                }
                W_filter.add(Filter_Function);
            }}
        return W_filter;
    }

    private ArrayList FilterWeight_BandPass_BandStop(String Filter_Type, int Sampling_Freq, int CutOff_Freq1,int CutOff_Freq2, long Filter_Order){
        float ft1 = CutOff_Freq1/Sampling_Freq;//TODO: check the condition if sampling freq = 0
        float ft2 = CutOff_Freq2/Sampling_Freq;
        float Filter_Function=0;

        if (Filter_Type == "Band Pass"){
            for (int n=0; n <= Filter_Order; n++){
                if (n != (Filter_Order/2)){
                    Filter_Function = (float) (( Math.sin(2*Math.PI*ft2*(n-Filter_Order/2))/(Math.PI*(n-Filter_Order/2)))-( Math.sin(2*Math.PI*ft1*(n-Filter_Order/2))/(Math.PI*(n-Filter_Order/2))));
                }else if (n == Filter_Order/2){
                    Filter_Function = 2*(ft2-ft1);
                }
                W_filter.add(Filter_Function);
            }
        }else if (Filter_Type == "Band Stop"){

            for (int n=0; n <= Filter_Order; n++){
                if (n != (Filter_Order/2)){
                    Filter_Function = (float) (( Math.sin(2*Math.PI*ft2*(n-Filter_Order/2))/(Math.PI*(n-Filter_Order/2)))-( Math.sin(2*Math.PI*ft1*(n-Filter_Order/2))/(Math.PI*(n-Filter_Order/2))));
                }else if (n == Filter_Order/2){
                    Filter_Function = 1 - 2*(ft2-ft1);
                }
                W_filter.add(Filter_Function);
            }}
        return W_filter;

        //after multiply the data array by W_filter array ...> this will give a single filtered data
        // then put it in filtered data array to use it in the differentiator.
    }
    private float filtered_Data(int data[]){
        for (int index=0; index<data.length; index++){
            y_filtered_dataPoint=y_filtered_dataPoint+data[index]* W_filter.get(index);
        }

        //this single data point will be added to a filter array
        return y_filtered_dataPoint;
    }

    private float Differentiator(float[] data){
        //data here is the filter output
        //and the output is a single data point.
        long W_diff[]= {1,-8,0,8,1};
        for (int index=0; index< W_diff.length; index++){
            y_diff_dataPoint = y_diff_dataPoint + data[index]*W_diff[index];
        }
        return y_diff_dataPoint;
    }

    private ArrayList Wieght_Window(String Window_Type, int order){
        float Wind_Function;
        if(Window_Type=="Rectangular"){
            for (int n=0; n<=order; n++){
                Wind_Function=1.0f;
                W_Window.add(Wind_Function);
            }

        }else if(Window_Type=="Bartlett"){
            for (int n=0; n<=order; n++){
                Wind_Function=1-2*Math.abs(n-order)/order;
                W_Window.add(Wind_Function);
            }

        }else if(Window_Type=="Hanning"){
            for (int n=0; n<=order; n++){
                Wind_Function= (float) (0.5-0.5*Math.cos(2*Math.PI*n/order));
                W_Window.add(Wind_Function);
            }

        }else if(Window_Type=="Hamming"){
            for (int n=0; n<=order; n++){
                Wind_Function= (float) (0.54-0.46*Math.cos(2*Math.PI*n/order));
                W_Window.add(Wind_Function);
            }
        }else if(Window_Type=="Blackman"){
            for (int n=0; n<=order; n++){
                Wind_Function= (float) (0.42-0.5*Math.cos(2*Math.PI*n/order)+0.08*Math.cos(4*Math.PI*n/order));
                W_Window.add(Wind_Function);
            }

        }

        return W_Window;
    }

}
