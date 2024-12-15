def find_count_to_turn_out_to_all_zero_or_all_one(string):
    zero_count = 0
    one_count = 0
    if string[0] == '0' :
        one_count = 1
    elif string[0] == '1' :
        zero_count = 1  

    for i in range(len(string) - 1) : # i는 len(string) - 2까지 
        if string[i] != string[i+1] :
            if string[i+1] == '1' :
                # 모두 0으로 만드는 count
                zero_count += 1
            else :
                # 모두 1로 만드는 count
                one_count += 1
            
    return min(zero_count, one_count)

string = input()
result = find_count_to_turn_out_to_all_zero_or_all_one(string)
print(result)