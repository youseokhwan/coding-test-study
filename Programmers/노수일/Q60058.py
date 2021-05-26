def solution(p):
    def right_bracket(bracket):
        b_list = list(bracket)
        tmp_list = []

        for b in b_list:
            if tmp_list and (b == ')' and tmp_list[-1] == '('):
                tmp_list.pop()
            else:
                tmp_list.append(b)
        if tmp_list:
            return False
        return True

    def divide_u_v(u_v):
        open = 0
        close = 0
        u_bracket = ''
        v_bracket = u_v

        for i in range(len(u_v)):
            if '(' == u_v[i]:
                open += 1
            elif ')' == u_v[i]:
                close += 1

            u_bracket += u_v[i]
            v_bracket = u_v[i + 1:len(u_v)]
            if open == close:
                break
        return u_bracket, v_bracket

    def recurse(s):
        if not s or s == '' or right_bracket(s):
            return s

        u, v = divide_u_v(s)

        if right_bracket(u):
            return u + recurse(v)
        else:
            tmp_v = '(' + recurse(v) + ')'
            tmp_u = ''

            for i in range(1, len(u) - 1):
                if u[i] == '(':
                    tmp_u += ')'
                elif u[i] == ')':
                    tmp_u += '('

            return tmp_v + tmp_u

    return recurse(p)
