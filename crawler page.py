# -*- coding: utf-8 -*-
"""
Created on Thu Jan 13 22:39:41 2022

@author: Gabi
"""

import time
import webbrowser as wb
import pyautogui as pag
import pynput as pyn
import urllib

wb.open_new_tab('https://www.nu10repair.ie')
time.sleep(0.5)
browser= wb.Chrome()
pag.moveTo(450,260)
pag.moveTo(350,360)
pag.moveTo(240,460)
webPage = urllib.requests.urlopen("https://icon.wd3.myworkdayjobs.com/en-US/broadbean_external/job/Ireland-Limerick/Pharmacologist_JR078995?source=icon_plc")

wb.open()
wb.get({browser: browser})
keyboard = pyn.keyboard.Controller()
webPage = urllib.request.urlopen('https://www.nu10repair.ie')
for line in webPage:
    text = line.decode("utf-8")
    print(text)
kb = pyn.keyboard
kb.press_and_release('ctrl + w, ctrl + w, \n')
tab = pyn.keyboard.key.tab
pag.click(-150,500)
# key.press(pyn.Key.backspace)
# key.press('entry')

position = pag.position()
for i in range(5,100, 2):
    for j in range(5, 40, 2):
      print('in ')
#      key.press(pyn.Key.ctrl)
#      key.press('w')
#      key.release(pyn.Key.ctrl)
 #     key.release('w')
      pag.click(-150+i*3,100+j*10 )
      
      wb.open_new_tab('https://www.nu10repair.ie')
      for _ in range(0,15):
        pyn.keyboard().press(pyn.Key.tab)
      pyn.keyboard().press(pyn.Key.enter)
      
    time.sleep(0.1)
          
      
        