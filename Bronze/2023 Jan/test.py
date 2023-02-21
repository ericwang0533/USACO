def main():
    n = int(input().strip())
    s = input().strip()
    e = list(map(int, input().strip().split()))
    ans = 0
    for i in range(n):
        if s[i] == 'G':
            other_breed_leader = s.find('H')
            if other_breed_leader == -1 or e[i] >= other_breed_leader:
                ans += s[:e[i]+1].count('G') == s[:e[i]+1].count('G')
        else:
            other_breed_leader = s.find('G')
            if other_breed_leader == -1 or e[i] >= other_breed_leader:
                ans += s[:e[i]+1].count('H') == s[:e[i]+1].count('H')
    print(ans)

if __name__ == '__main__':
    main()
