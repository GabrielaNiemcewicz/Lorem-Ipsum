# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import random as r
import numpy as np
from sklearn.tree import DecisionTreeClassifier 
import pandas
import sklearn.preprocessing as p
import matplotlib.pyplot as plt
import sklearn.decomposition as skl
elements = []

#dictionary= {sum=0;above=0}

#n= input('How many elements')
sum = 0
n=50
above=0
values = [r.randrange(1,10) for j in range(0,n)]
cents = [np.ceil(r.randrange(0,100))/100 for j in range(0,n)]
effect = [values[j]+cents[j] for j in range(0,n)]
 #{[['effect':[effect], 'values:' [values]}]]

n = int(n)
print(n)
print(type(n))

r.seed(38)
ceil = 5*n
for _ in range(0,n):
    if(sum<ceil):
      x = r.randrange(1,10)
      elements.append(x)
      print(values[x]," <- " , x)
      sum+=values[x]
    else :
      above+=1
print(sum<ceil,"sum: ", sum/ceil)


decision = DecisionTreeClassifier()
#dffect = np.concatenate([[effect], [values]], axis = -1)
#effect = np.reshape(effect, (1,2))
#effect = [effect]
#decision.fit(effect, cents)
#y = [[10.10, 13.82, 11.09, 1.00, 1.00, 4.82],
 #                             [0.10, 0.82, 0.09, 0, 0, 82]]


# =============================================================================
# predicted = decision.predict(y)
# =============================================================================

dframe = [[4,3,2,4,6,1,3,2,4,1,3,4,4],
 [4.16,3.90,2.12,4.44,6.90,1.00,3.38,2.89,4.03,1.34,3.41,4.67,4.89]]

picked = [0,1,1,1,0,1,1,0,1,1,0,1,0]
effects = [dframe[1][i]-dframe[0][i] for i in range(0,len(dframe[1])-1)]
effects = np.round(effects,2)
oh_enc = p.OneHotEncoder();
dframe = np.rot90(dframe,1)
dframe = pandas.DataFrame(dframe)
#training_scores_encoded = oh_enc.fit_transform(picked)

model=decision.fit(dframe, picked)     
                                             

#plt.plot(X=dframe, Y= picked)
pca = skl.PCA(2)
model_t= pca.fit_transform(X=dframe, y=picked )

plt.scatterplot(model_t)

