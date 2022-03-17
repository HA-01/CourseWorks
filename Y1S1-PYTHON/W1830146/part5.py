
# W.A.L.H.N.WICKRAMA ARACHCHI

# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# UOW ID-W1830146

# Student ID: 20200477         
  
# Date: 25.04.2021

# part 5

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

score_levels=([120,0,0],[100,20,0],[100,0,20],[80,20,20],[60,40,20],[40,40,40],[20,40,60],[20,20,80],[20,0,100],[0,0,120])


for x in range(len(score_levels)):
    
    Pass=score_levels[x][0]
    if(data(Pass) == 'incorrect'):
            print("out of range")
            continue
    Defer=score_levels[x][1]
    if(data(Defer) == 'incorrect'):
            print("out of range")
            continue
    Fail=score_levels[x][2]
    if(data(Fail) == 'incorrect'):
            print("out of range")
            continue
        
    if (Pass+Defer+Fail  !=  120):              #checking the summation of Pass,Defer anf Fail
            print('Total incorrect')
            continue
                
    
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



    
print('-----------------------------------------------------------------')
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






