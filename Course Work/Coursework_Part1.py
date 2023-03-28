# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. 
# Any code taken from other sources is referenced within my code solution. 
# Student ID: w1868307 
# Date: 8.12.2021
#Part 1 - Main Version
#Student Version
choice = ''
total = 0
progress_count = 0
trailer_count = 0
retriver_count = 0
excluded_count = 0
total_outcomes = 0

student_records={}

def progression_outcome():
    global progress_count
    global trailer_count
    global retriver_count
    global excluded_count

    if (pass_credit == 120):
        print('Progress')
        progress_count += 1
    elif (pass_credit== 100):
        print('Progress(module trailer)')
        trailer_count += 1
    elif(pass_credit >= 60 and pass_credit <= 80):
        print('Do not progress - module retriever')
        retriver_count += 1
    elif (pass_credit == 40 and defer_credit != 0):
        print('Do not progress - module retriever')
        retriver_count += 1
    elif (pass_credit == 20 and defer_credit !=0 and defer_credit !=20 ):
        print('Do not progress - module retriever')
        retriver_count += 1
    elif (pass_credit ==0 and defer_credit !=0 and defer_credit != 20 and defer_credit != 40):
        print('Do not progress - module retriever')
        retriver_count += 1
    else:
        print('Exclude')
        excluded_count += 1


number_of_students = 0
students = 'stu'

while choice != 'q':
    try:
        
        pass_credit = input('Enter your total PASS credits: ')
        pass_credit = int(pass_credit)
        if (pass_credit > 120 or pass_credit < 0):
            print('Out of range')
            continue
        elif (pass_credit % 20 != 0):
            print('Out of range')
            continue
        defer_credit = input('Enter your total DEFER credits: ')
        defer_credit = int(defer_credit)
        if (defer_credit > 120 or defer_credit < 0):
            print('Out of range')
            continue
        elif (defer_credit % 20 != 0):
            print('Out of range')
            continue
        fail_credit = input('Enter your total FAIL credits: ')
        fail_credit = int(fail_credit)
        if (fail_credit > 120 or fail_credit < 0):
            print('Out of range')
            continue
        elif (fail_credit % 20 != 0):
            print('Out of range')
            continue
    except ValueError: 
        print('Integer required')
        continue
    total = pass_credit + defer_credit + fail_credit
    if total != 120:
        print('Total incorrect')
        continue
    else:
        progression_outcome()
        number_of_students += 1
        students = ('stu:',number_of_students)
        student_records[students] = (pass_credit,defer_credit,fail_credit)
    choice = str(input('Would you like to enter another set of data? \nEnter "y" for yes or "q" to quit and view results: '))
    if choice == 'q':
        break
    elif choice != 'y':
        print('Wrong Input')
        continue
    elif choice == 'y':
        continue
   

#Part 1 - Staff version
print('Staff version with Histogram')

choice = ''
total = 0
progress_count = 0
trailer_count = 0
retriver_count = 0
excluded_count = 0
total_outcomes = 0

student_records={}

def progression_outcome():
    global progress_count
    global trailer_count
    global retriver_count
    global excluded_count

    if (pass_credit == 120):
        print('Progress')
        progress_count += 1
    elif (pass_credit== 100):
        print('Progress(module trailer)')
        trailer_count += 1
    elif(pass_credit >= 60 and pass_credit <= 80):
        print('Do not progress - module retriever')
        retriver_count += 1
    elif (pass_credit == 40 and defer_credit != 0):
        print('Do not progress - module retriever')
        retriver_count += 1
    elif (pass_credit == 20 and defer_credit !=0 and defer_credit !=20 ):
        print('Do not progress - module retriever')
        retriver_count += 1
    elif (pass_credit ==0 and defer_credit !=0 and defer_credit != 20 and defer_credit != 40):
        print('Do not progress - module retriever')
        retriver_count += 1
    else:
        print('Exclude')
        excluded_count += 1

def horizontal_histogram():
    print('Horizontal Histogram')
    print('Progress', progress_count,':', progress_count * '*')
    print('Trailer', trailer_count, ':',trailer_count * '*')
    print('Retriver', retriver_count,':',retriver_count* '*')
    print('Excluded', excluded_count,':',excluded_count* '*')
    total_outcomes = progress_count + trailer_count + retriver_count + excluded_count
    print()
    print(total_outcomes, 'outcomes in total.')
    
