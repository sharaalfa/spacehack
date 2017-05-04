#! /usr/bin/python
# -*- encoding: UTF-8 -*-
import numpy
import pandas
import xgboost
from sklearn import cross_validation
from sklearn.metrics import accuracy_score

# Загрузка данных
change_data = pandas.read_csv('results_google.csv')
# проверка корреляции переменных между собой
print change_data.corr()

print change_data[[1, 2-3]].corr()

print change_data[[2, 3-4]].corr()

print change_data[[3, 1-2]].corr()

print change_data[[4, 1-2]].corr()

print change_data[[1, 2-4]].corr()

print change_data[[4, 1-3]].corr()

# удаление колонок 2, 4, 5
del change_data['81']

del change_data['81.1']

del change_data['56.2']

# сохрание в файл csv
change_data.to_csv('result_google_1and3.csv', index=False)

# подготовка датасета
dataset = numpy.loadtxt('set.csv', delimiter=',')



# выделим оклик и фичи для переменных с высоко  корреляцией
X = dataset[:,0:5]
Y = dataset[:,5]

# определим обучающую и тестовую выборки
X_train, X_test, y_train, y_test = \
    cross_validation.train_test_split(X, Y, test_size=0.1, random_state=1)

# модель классификатора XGBoost
model = xgboost.XGBClassifier()
model.fit(X_train, y_train)

# делаем прогноз для тестовой выборки
y_pred = model.predict(X_test)
predictions = [round(value) for value in y_pred]

# точность предсказания
accuracy = accuracy_score(y_test, predictions)
print "Точность: %.2f%%" % (accuracy * 100.0)


