import math

def find_prime_list_under_number(num1, num2):
    answer = []
    # 마지막 숫자까지의 전체 숫자에서 소수 여부를 True False로 판단
    is_prime = [True for i in range(num2 + 1)]
    is_prime[1] = False
    # 2부터터 마지막 숫자의 제곱근+1 까지
    for i in range(2, int(math.sqrt(num2))+1) :
        if is_prime[i] == True :
            p = 2
            while i * p <= num2 :
                is_prime[i*p] = False # p값의 배수는 False
                p += 1
                
    # 시작 숫자부터 마지막 숫자까지의 소수 걸러내기
    for i in range(num1, num2+1) :
        if is_prime[i] :
            answer.append(i)
    return answer
                

num1, num2 = map(int, input().split())
result = find_prime_list_under_number(num1, num2)
for num in result :
    print(num)