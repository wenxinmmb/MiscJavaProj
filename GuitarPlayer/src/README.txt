I used StdAudio and StdDraw libraries to help manipulate .wav files and handle inputs from the keyboard.

Physics and Algorithms of guitar simulation:

Plucking the string
When a guitar string is plucked, the string vibrates and creates sound. The length of the string determines its fundamental frequency of vibration. I model a guitar string by sampling its displacement (a real number between -1/2 and +1/2) at N equally spaced points (in time), where N equals the sampling rate (44,100) divided by the fundamental frequency (rounded to the nearest integer). I store these displacement values in a structure that I will refer to as a ring buffer.
The excitation of the string can contain energy at any frequency. I simulate the excitation by filling the ring buffer with white noise: set each of the N sample displacements to a random real number between -1/2 and +1/2.

The Resulting Vibrations
After the string is plucked, the string vibrates. The pluck causes a displacement which spreads wave-like over time. The Karplus-Strong algorithm simulates this vibration by maintaining a ring buffer of the N samples: the algorithm repeatedly deletes the first sample from the ring buffer and adds to the end of the ring buffer the average of the first two samples, scaled by an energy decay factor of 0.996.

Why It Works
The two primary components that make the Karplus-Strong algorithm work are the ring buffer feedback mechanism and the averaging operation.
The ring buffer feedback mechanism. The ring buffer models the medium (a string tied down at both ends) in which the energy travels back and forth. 
1. The length of the ring buffer determines the fundamental frequency of the resulting sound. Sonically, the feedback mechanism reinforces only the fundamental frequency and its harmonics (frequencies at integer multiples of the fundamental). The energy decay factor (.996 in this case) models the slight dissipation in energy as the wave makes a roundtrip through the string.
2. The averaging operation. The averaging operation serves as a gentle low pass filter (which removes higher frequencies while allowing lower frequencies to pass, hence the name). Because it is in the path of the feedback, this has the effect of gradually attenuating the higher harmonics while keeping the lower ones, which corresponds closely with how actually plucked strings sound.


How to run the program:

Part1: Running Guitar221.java, which simulate a guitar with 37 strings(scale from 110Hz to 880Hz), users are able to play songs by pressing buttons on the keyboard. The ith string of the guitar correspond to the ith character of the array " q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "

This "keyboard" arrangement imitates a piano keyboard, making playing songs a little easier for people used to a piano keyboard. The "white keys" are on the qwerty and zxcv rows and the "black keys" on the 12345 and asdf rows of the keyboard.

Part2: After running PlayThatTune.java, users can choose a song to play. The program will read from the corresponding .txt file and generate the music automatically.

