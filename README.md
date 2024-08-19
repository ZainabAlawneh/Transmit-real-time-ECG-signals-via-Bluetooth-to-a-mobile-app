# Real-time ECG Signal Transmission via Bluetooth

### This project is a complete system for transmitting real-time ECG signals via Bluetooth to a mobile application. The project includes both the hardware interface using a Teensy microcontroller and an HM-11 Bluetooth module, as well as a native Android application to receive and display the ECG data.
## Table of Contents

    Overview
    Hardware Setup
    Software Setup
        Arduino Code
        Android App
    How It Works
    Installation
        Hardware Setup
        Software Setup
    Usage
    Contributing
    License

## Overview
### This project demonstrates how to capture ECG signals in real-time and transmit them wirelessly using Bluetooth technology. The system was developed as part of my graduation project, and I was solely responsible for all aspects of the design and implementation.

## Hardware Setup
### The hardware components used in this project are:

    ### Teensy Microcontroller: Used for capturing ECG signals and processing them for transmission.
    HM-11 Bluetooth Module: Used for wireless communication between the Teensy and the Android mobile app.

## Software Setup
## Arduino Code

### The Arduino code for the Teensy microcontroller is located in the TeensyCode directory. This code handles the reading of the ECG signal, processing it, and sending the data via Bluetooth.
Android App

### The Android native application, located in the AndroidApp directory, receives the Bluetooth data and displays the real-time ECG signal. The app was built using Android Studio.
How It Works

    The Teensy microcontroller captures the ECG signal using the appropriate sensors.
    The signal is processed and transmitted via the HM-11 Bluetooth module.
    The Android app receives the Bluetooth signal and displays the ECG data in real-time.

## Installation
## Hardware Setup

    ### Connect the ECG sensor to the Teensy microcontroller.
   ### Set up the HM-11 Bluetooth module with the Teensy.
    ### Ensure that the connections are secure and that the Teensy is properly powered.

## Software Setup

   ### Upload the Arduino code from the TeensyCode directory to the Teensy microcontroller using the Arduino IDE.
    ### Install the Android app on your mobile device by building the project from the AndroidApp directory using Android Studio.

## Usage

    ### Power on the Teensy microcontroller.
    Ensure that the Android device has Bluetooth enabled and that the app is running.
    Pair the Android device with the HM-11 Bluetooth module.
    The ECG signal should begin transmitting and display in the app.

## Contributing

If you wish to contribute to this project, please feel free to email me at # Zainab.alawneh96@gmail.com