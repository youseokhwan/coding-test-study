def solution(s):
    s_list = []
    for st in s.split(' '):
        if st == '':
            s_list.append('')
            continue
        if len(st) == 1:
            st = st.upper()
        else:
            st = st.lower()
            st = st[0].upper() + st[1:]
        s_list.append(st)

    answer = ' '.join(s_list)
    return answer
