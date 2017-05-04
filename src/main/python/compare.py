#! /usr/bin/python
# -*- encoding: UTF-8 -*-

import pandas
import numpy
data_test = pandas.read_csv('google.csv')
data_gender = pandas.read_csv('google11.csv')

#print data_test['1424268900187']
#print data_gender[u'f         ']
#print data_gender['1407320454993']

for i in range(1, 999):
    for j in range(1, 35783):
        if data_gender['1407320454993'].loc[i] == data_test['1424268900187'].loc[j]:
            p= data_test.loc[j]['56.2']
            p1 = data_test.loc[j]['81.1']
            p2 = data_test.loc[j]['81']
            p3 = data_test.loc[j]['56.1']
            p4 = data_test.loc[j]['56']
            c=data_gender.loc[i][u'Unnamed: 1']
            f = open("562.txt", "a")
            f.write("\n" + str(p))
            f.close()
            f = open("811.txt", "a")
            f.write("\n" + str(p1))
            f.close()
            f = open("81.txt", "a")
            f.write("\n" + str(p2))
            f.close()
            f = open("561.txt", "a")
            f.write("\n" + str(p3))
            f.close()
            f = open("56.txt", "a")
            f.write("\n" + str(p4))
            f.close()
            f = open("sex.txt", "a")
            f.write("\n" + str(c))
            f.close()
            print c








