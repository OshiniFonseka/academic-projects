# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. 
# Any code taken from other sources is referenced within my code solution. 
# Student ID: w1868307 
# Date: 8.12.2021
#Part 4 - Text file
def text_file():
    global progress_count
    global trailer_count
    global retriver_count
    global excluded_count

    credit_list=list(student_records.values())
    line = ""
    file1 = open("pythontext.txt","w")

    for i in range(0,len(credit_list)):
        pass_credit = int(credit_list[i][0])
        defer_credit = int(credit_list[i][1])
        fail_credit = int(credit_list[i][2])

        if (pass_credit == 120):
            line = 'Progress - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit), ' \n'            
        elif (pass_credit== 100):
            line = 'Progress(module trailer) - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit)            
        elif(pass_credit >= 60 and pass_credit <= 80):
            line = 'Do not progress - module retriever - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit)            
        elif (pass_credit == 40 and defer_credit != 0):
            line = 'Do not progress - module retriever - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit)            
        elif (pass_credit == 20 and defer_credit !=0 and defer_credit !=20 ):
            line = 'Do not progress - module retriever - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit)            
        elif (pass_credit ==0 and defer_credit !=0 and defer_credit != 20 and defer_credit != 40):
            line = 'Do not progress - module retriever - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit)            
        else:
            line = 'Exclude - ' , str(pass_credit) , ', ', str(defer_credit), ', ', str(fail_credit)            

                  
        file1.writelines(line)
    file1.close()
