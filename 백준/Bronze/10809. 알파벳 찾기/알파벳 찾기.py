string=input()
ap_list=[-1 for i in range(26)]
for letter in string :
    ap_list[ord(letter)-97]=string.index(letter)

print(*ap_list)