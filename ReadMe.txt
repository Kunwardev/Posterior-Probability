Name: Kunwar Dev Singh
UTA ID: 1001448465
Programming Language: Java

There is only one file with the name of compute_a_posteriori.java. 
In order to run the file on omega, The program should be invoked from the commandline as follows:
	
	compute_a_posteriori observations

A result.txt file will be made that will store the contents as shown below:

Observation sequence Q: ???
Length of Q: ???

P(h1 | Q) = ???
P(h2 | Q) = ???
P(h3 | Q) = ???
P(h4 | Q) = ???
P(h5 | Q) = ???

Probability that the next candy we pick will be C, given Q: ???
Probability that the next candy we pick will be L, given Q: ???

In the file, the structure of code is as follows:
the code will read the arguments and then it will count the numbers of L and C.
An array of double with the name of Pd_h_CL is initialized and the other array of double with the name of
Ph, and then a double of alpha and a sum is initialized along with the array of double with name of P_C.
The value of P_C represents the probability of picking up the cherry candy from the respective bag, and the
Ph value is given to us. Then the required algorithm is applied on the values of Pd_h_CL, and those values are
added in the sum, and the sum is reversed in order to get the value of alpha. This alpha is then multiplied with
the Pd_h_CL that will give us the new P_h_CL. 
All these values are then written in the result.txt.
The Task 2 and Task 3 are present in a pdf file under the name of "Task 2 and Task 3.pdf" 