import numpy
from time import process_time
# 3x3 matrix
X = [[12,714,4065],
    [458,558,155],
    [786 ,858,6054]]

# 3x4 matrix
Y = [[525,8387,1088,2],
    [614,756,30035,1],
    [417,552,12325,6]]


t1_start = process_time()
result = [[sum(a*b for a,b in zip(X_row,Y_col)) for Y_col in zip(*Y)] for X_row in X]
print("result my function:   ",result)
print()
t1_stop = process_time()
print ("timing my function:\t ", [{t1_stop-t1_start}])
print("\t")
t1_start = process_time()
c = numpy.dot(X,Y)
print("numpy result:   ", c)

t1_stop = process_time()
print()
print("numpy timing:\t ",[{t1_stop-t1_start}])
