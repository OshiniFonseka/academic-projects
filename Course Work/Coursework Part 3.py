# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. 
# Any code taken from other sources is referenced within my code solution. 
# Student ID: w1868307 
# Date: 8.12.2021
#Part 3 - List/Tuple/Directory
def stored_data():
    global progress_count
    global trailer_count
    global retriver_count
    global excluded_count

    credit_list=list(student_records.values())
    

    for i in range(0,len(credit_list)):
        pass_credit = int(credit_list[i][0])
        defer_credit = int(credit_list[i][1])
        fail_credit = int(credit_list[i][2])

        if (pass_credit == 120):
            print('Progress - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        elif (pass_credit== 100):
            print('Progress(module trailer) - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        elif(pass_credit >= 60 and pass_credit <= 80):
            print('Do not progress - module retriever - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        elif (pass_credit == 40 and defer_credit != 0):
            print('Do not progress - module retriever - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        elif (pass_credit == 20 and defer_credit !=0 and defer_credit !=20 ):
            print('Do not progress - module retriever - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        elif (pass_credit ==0 and defer_credit !=0 and defer_credit != 20 and defer_credit != 40):
            print('Do not progress - module retriever - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        else:
            print('Exclude - ', pass_credit, ' , ', defer_credit,  ' , ', fail_credit)
        
