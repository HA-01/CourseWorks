
# W.A.L.H.N.WICKRAMA ARACHCHI

# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# UOW ID-W1830146

# Student ID: 20200477         
  
# Date: 20.04.2021

# part 4 



Pass=0
Defer=0
Fail=0

def total(Pass,Defer,Fail):
    if(Pass+Defer+Fail!= 120):
        print('Total incorrect')

def data(value):
    if(value not in range(0,140,20)):
        return 'incorrect'

progress = 0
moduletrailer = 0
moduleretriever = 0
exclude = 0
Total = 0

#Entering credits at pass,deffer and fail statuses

       
while True:
    try:
        Pass = int(input('Please enter your credits at pass:='))  #credit at pass

        if(data(Pass) == 'incorrect'):
            print("out of range")
            continue
        Defer = int(input('Please enter your credit at defer:=')) #credit at deffer
        if(data(Defer) == 'incorrect'):
            print("out of range")
            continue
        Fail = int(input('Please enter your credit at fail:='))   #credit at fail

        if(data(Fail) == 'incorrect'):
            print("out of range")
            continue
        
        if (Pass+Defer+Fail  !=  120):                            #checking the summation of Pass,Defer anf Fail
            print('Total incorrect')
            continue
                
    except ValueError:
        print('Integer required')

    Total=Total+1    

    if(Pass) == 120:
        print( "Progress outcome is Progress")
        progress = progress+1
    elif(Pass) == 100:
        print("Progress outcome is progress(module trailer)")
        moduletrailer = moduletrailer + 1
    elif(Fail) >= 80:
        print ("Progress outcome is Exclude")
        exclude =exclude +1
    else:
        print ("Progress outcome is Do not Progress – module retriever")
        moduleretriever =moduleretriever + 1
        
#choice of entering data or quitting

    print('Would you like to enter another set of data?')
    option = input('Enter "y" for yes or "q" to quit and view results:')

    if(option == 'y'):
        continue
    if(option == 'q'):
        break

print('-----------------------------------------------------------------------------')

#HORIZONTAL HISTOGRAM

print('Progress  ', end='')
print(progress,' : ',end='')
print('*'*progress)

print('Trailer  ', end='')
print( moduletrailer,'  : ',end='')
print('*'*moduletrailer)

print('Retriever  ', end='')
print( moduleretriever,': ',end='')
print('*'*moduleretriever)

print('Excluded  ', end='')
print( exclude,' : ',end='')
print('*'*exclude)

print()
print()

print(Total,'outcomes in total.')
print('-----------------------------------------------------------------------------')

#VERTICAL HISTOGRAM


print('Progress',progress, '|'' ' 'Trailer',moduletrailer, '|'' ' 'Retriever',moduleretriever,'|'' '  'Exclude',exclude )
print()

for status in range(max(progress,moduletrailer,moduleretriever,exclude)):
    print('    {0}            {1}           {2}              {3}'.format(
'*' if status < progress else ' ',
'*' if status < moduletrailer else ' ',
'*' if status < moduleretriever else ' ',
'*' if status < exclude else ' '))

print(Total,'outcomes in total.')    





