# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion. 
# Any code taken from other sources is referenced within my code solution. 
# Student ID: w1868307 
# Date: 8.12.2021
#Part 2 - Vertical Histogram
def vertical_histogram():
    global progress_count
    global trailer_count
    global retriver_count
    global excluded_count
    
    total_complete = 0

    progress_symbol = '' 
    progress = 0

    trailer_symbol = ''
    trailer = 0

    retriver_symbol = ''
    retriver = 0

    excluded_symbol = ''
    excluded = 0

    total_var = 0
    print('Progress    Trailing    Retriver    Excluded')
    while total_complete != 4:
        if progress_count > 0:
            progress_symbol = '*'
            progress_count -= 1
            progress = 0
        else:
            progress_symbol = ''
            progress = 1
                
        if trailer_count > 0:
            trailer_symbol = '*'
            trailer_count -= 1
            trailer = 0
        else:
            trailer_symbol = ''
            trailer = 1
            
        if retriver_count > 0:
            retriver_symbol = '*'
            retriver_count -= 1
            retriver = 0
        else:
            retriver_symbol = ''
            retriver = 1
            
        if excluded_count > 0:
            excluded_symbol = '*'
            excluded_count -= 1
            excluded = 0
        else:
            excluded_symbol = ''
            excluded = 1
            
        print('   ',progress_symbol,'         ',trailer_symbol,'          ',retriver_symbol,'         ',excluded_symbol)
        total_complete = progress + trailer + retriver + excluded






