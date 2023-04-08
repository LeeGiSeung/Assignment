import numpy as np
import pandas as pd
import csv

A = np.array([[1,2,3],[4,5,6]])

a = [1,2,3,4,5,6]

# [[1,2,3,4,5],
#  [1,2,3,4,5],
#  [1,2,3,4,5]
#  [1,2,3,4,5]
#  [1,2,3,4,5]
#  [1,2,3,4,5]]

a[5]
print(a[[4][2]])

# print(A)

# with open('수진이 수업 데이터.csv','r', encoding='euc-kr') as f:
#     data = list(csv.reader(f, delimiter=",",))

# data = np.array(data)
# print(data)


