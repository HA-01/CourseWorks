
# W.A.L.H.N.WICKRAMA ARACHCHI

# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# UOW ID-W1830146

# Student ID: 20200477         
  
# Date: 14.04.2021

# part2


Pass=0
Defer=0
Fail=0

def total(Pass,Defer,Fail):
    if(Pass+Defer+Fail!= 120):
        print('Total incorrect')

def data(value):
    if(value not in range(0,140,20)):
        return 'incorrect'
    
#Entering credits at pass,defer and fail statuses

       
while True:
    try:
        Pass = int(input('Please enter your credits at pass:=')) #credit at pass
        if(data(Pass) == 'incorrect'):
            print("out of range")
            continue
        Defer = int(input('Please enter your credit at defer:='))#credit at defer
        if(data(Defer) == 'incorrect'):
            print("out of range")
            continue
        Fail = int(input('Please enter your credit at fail:='))  #credit at fail
        if(data(Fail) == 'incorrect'):
            print("out of range")
            continue
        if (Pass+Defer+Fail  !=  120):                           #checking the summation of Pass,Defer anf Fail
            print('Total incorrect')
            continue
                
    except ValueError:
        print('Integer required')
        continue

    if(Pass) == 120:
        print( "Progress outcome is Progress")
    elif(Pass) == 100:
        print("Progress outcome is progress(module trailer)")
    elif(Fail) >= 80:
        print ("Progress outcome is Exclude")
    else:
        print ("Progress outcome is Do not Progress – module retriever")



