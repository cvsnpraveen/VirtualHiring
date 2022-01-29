from django.shortcuts import render
from .models import stock,order
import requests

def home(request):
    s=stock.objects.filter(stackStatus=True)
    o=order.objects.all()
    return render(request,"home.html",{"stock":s,"o":o})


def neworder(request):
    ordername=request.POST["ordername"]
    x=stock.objects.get(id=int(ordername))
    price=request.POST["price"]
    order_qty=request.POST["orderqty"]
    order_type=request.POST["ordertype"]
    order_status="PLACED"
    if order_type=="Market":
        price=0
    t=order(stock=x,price=price,order_qty=order_qty,order_type=order_type,orderstatus=order_status)
    t.save()
    s=stock.objects.filter(stackStatus=True)
    o=order.objects.all()
    return render(request,"home.html",{"stock":s,"o":o})

def adminpage(request):
    s=stock.objects.filter(stackStatus=True)
    o=order.objects.all()
    return render(request,"admin.html",{"stock":s,"o":o})

def adminupdate(request):
    executionqty=request.POST["executionqty"]
    executionprice=request.POST["executionprice"]   