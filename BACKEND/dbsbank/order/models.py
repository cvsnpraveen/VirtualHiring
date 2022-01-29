from django.db import models
from django.contrib.auth.models import User
from datetime import date

# Create your models here.

class stock(models.Model):
    stockName=models.TextField()
    stackStatus=models.BooleanField()

orderType=(
    ("Limit","Limit"),
    ("Market","Market")
)

orderStatus=(
    ("PLACED","PLACED"),
    ("PROCESSED","PROCESSED"),
    ("ACCEPTED","ACCEPTED"),
    ("REJECTED" ,"REJECTED")
)

class order(models.Model):
    #user = models.ForeignKey(User, on_delete=models.CASCADE)
    stock=models.ForeignKey(stock, on_delete=models.CASCADE)
    order_qty=models.IntegerField(default=0)
    order_type=models.CharField(max_length=20,choices=orderType)
    executed_qty=models.IntegerField(default=0)
    price=models.IntegerField(default=0)
    orderstatus=models.CharField(max_length=20,choices=orderStatus)
    orderdate = models.DateField(default=date.today)
