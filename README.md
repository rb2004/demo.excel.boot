
# Project Title

A brief description of what this project does and who it's for

It accepts data from excel and stores the information to db.
## Demo

Insert gif or link to demo

https://github.com/rb2004/demo.excel.boot.git
## API Reference


#### Get product API

```http
  GET /api/("/product")
```

| Parameter | Type     | Description                       |
| :-------- | :------ | :-------------------------------- |
| `productId`|Integer | Unique Id for all the products in the table|
|productName |String|   Name of the product present in the table|
|productDesc|String| Description of the product present in the table|
|productPrice|Double| Price of the product present in the table|

  #### Post Product API
  POST/api/(product/upload)

  #### Method

public static boolean checkExcelFormat(MultipartFile file)-> It checks if the file we are taking as input is in Excel format or not.

#### File configuration

spring.servlet.multipart.max-file-size=3MB

spring.servlet.multipart.max-request-size=3MB
