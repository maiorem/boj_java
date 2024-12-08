def solution(array):
    occurrent_array = [0]*1000
    for item in array :
        occurrent_array[item] += 1
    max = 0
    answer = -1
    for i in range(len(occurrent_array)) :
        if max < occurrent_array[i] :
            max = occurrent_array[i]
            answer = i
    for i in range(len(occurrent_array)) :
        if answer != i and max == occurrent_array[i] :
            answer = -1
    return answer
        