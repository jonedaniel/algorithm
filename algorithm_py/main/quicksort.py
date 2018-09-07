arr = [
    2, 4, 5, 5, 6, 7, 11, 11, 11, 12, 12, 13, 13, 13, 13, 14, 16, 18, 19, 19, 19, 22, 22, 23, 27, 29, 29, 30, 31, 33,
    37,
    38, 38, 38, 39, 39, 40, 40, 41, 42, 42, 43, 43, 46, 46, 50, 50, 52, 55, 57, 57, 57, 58, 59, 59, 59, 59, 59, 60, 62,
    65,
    65, 65, 67, 68, 68, 68, 68, 71, 73, 73, 73, 73, 73, 73, 74, 75, 76, 76, 80, 82, 82, 83, 83, 86, 87, 91, 93, 93, 93,
    93,
    94, 94, 94, 95, 96, 96, 96, 97, 98]


def binary_search(arr, aim):
    sign = 0
    ret = binary_recursion(arr, aim, 0, len(arr), sign)
    if ret.isalpha():
        return ret
    return ret if ret < 0 else "数组中不存在此值"


def binary_recursion(arr, aim, s, b, sign):
    sign += 1
    if sign == 997:
        return "递归过深"
    mid = s + b >> 1
    if s > b:
        return -1
    if arr[mid] == aim:
        return mid
    elif arr[mid] > aim:
        return binary_recursion(arr, aim, s, mid, sign)
    elif arr[mid] < aim:
        return binary_recursion(arr, aim, mid, b, sign)


def select_sort(arr):
    length = len(arr)
    min = 0
    for i in range(0, length - 1):
        min = i
        for j in range(i + 1, length):
            if arr[min] > arr[j]:
                min = j
        temp = arr[i]
        arr[i] = arr[min]
        arr[min] = temp


def insert_sort(arr):
    length = len(arr)
    for i in range(1, length):
        temp = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > temp:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = temp


def bubble_sort(arr):
    length = len(arr)
    for i in range(1, length):
        for j in range(i, length).__reversed__():
            if arr[j] < arr[j - 1]:
                temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp


# select_sort(arr)
# insert_sort(arr)
# bubble_sort(arr)
ret = binary_search(arr, 32)
print(ret)
print(arr)
