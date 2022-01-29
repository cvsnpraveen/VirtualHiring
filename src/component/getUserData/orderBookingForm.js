import React from 'react';
import { useState } from "react";
import Select from 'react-select';

function OrderBookingForm() {
  const [stockName, setStockName] = useState("");
  const [orderType, setOrderType] = useState("");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");
  const stockList = [
    { value: 'dbs', label: 'DBS' },
    { value: 'sbi', label: 'SBI' },
    { value: 'yesbank', label: 'Yes Bank' }
  ];
  const orderTypeList = [
    { value: 'limit', label: 'Limit' },
    { value: 'market', label: 'Market' },
  ]

  const handleSubmit = (event) => {
    event.preventDefault();

    let bookedOrderData = {
      stockName,
      orderType,
      price,
      quantity
    }

    console.log(bookedOrderData);
    setStockName('');
    setOrderType('');
    setPrice('');
    setQuantity('');

  }

  return (
    <div className='form-container'>
    <form onSubmit={handleSubmit}>
      <h1 className="form-heading">Customer Book Order Page</h1>
      <div className="field-container">
        <label>Search Stock</label>
        <Select classNamePrefix={'react-select'} options={stockList} onChange={(e) => setStockName(e.value)}/> 
       </div>
      <div className="field-container">
        <label>Order Type</label>
        <Select classNamePrefix={'react-select'} options={orderTypeList} onChange={(e) => setOrderType(e.value)}  /> 
      </div>
      <div className="field-container">
        <label>Price</label>
        <input
          className="form-field"
          type="number" 
          value={price}
          onChange={(e) => setPrice(e.target.value)} 
        />
      </div>
      <div className="field-container">
        <label>Quantity</label>
        <input
          className="form-field"
          type="number" 
          value={quantity}
          onChange={(e) => setQuantity(e.target.value)} 
        />
      </div>
      <div className='button-container'>
        <button type="submit">
          Place Order
        </button>
      </div>
    </form>
    </div>
  )
}
export default OrderBookingForm;
