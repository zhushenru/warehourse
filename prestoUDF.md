# ip_lookup

## 解析IP数据中的地理位置

###  请求参数

| **类型** | **是否必填** | **参数描述** |
| -------- | ------------ | ------------ |
| string   | true         | 用户ip       |
| string   | false        | ip库文件路径 |

### 返回参数

| **类型** | **描述**                                             |
| -------- | ---------------------------------------------------- |
| struct   | { "country", "province", "city", "isp" ,"countryid"} |

### 使用例子

```
select ip_lookup('129.29.28.2') ; ==>> {"country":"美国","province":"美国","city":"","isp":"","countryid":"US"}
select ip_lookup('129.29.28.2').country; ==>> 美国
```

# intesect_2_list

## 两个集合list的交集

### 请求参数

| **类型** | **是否必填** | **参数描述** |
| -------- | ------------ | ------------ |
| list     | true         | list参数     |
| list     | true         | list参数     |

### 返回参数

| 类型 | 描述           |
| ---- | -------------- |
| list | 两个集合的交集 |

### 使用例子

```
 select intesect_2_list( array[1,2,3],array[2,3,45,6]);==>>[2, 3]
```

# get_weekday

## 获取日期是星期几

### 请求参数

| **类型**              | **是否必填** | **参数描述** |
| --------------------- | ------------ | ------------ |
| string/date/timestamp | true         | 日期         |

### 返回参数

| **类型** | **描述**    |
| -------- | ----------- |
| int      | 星期几(1-7) |

### 使用例子

```
 select get_weekday('2019-01-29');
->2
```

# trim_pre_suffix

## 去除首尾指定字符串

### 请求参数

| **类型** | **是否必填** | **参数描**       |
| -------- | ------------ | ---------------- |
| string   | true         | 内容             |
| string   | true         | 要去除的首字符串 |
| string   | true         | 要去除的尾字符串 |

### 返回参数

| **类型** | **描述**         |
| -------- | ---------------- |
| string   | 去除首尾后的内容 |

### 使用例子

```
 select trim_pre_suffix('_f_xd_ab_','_f_','_');==>>xd_ab
```

# get_trust_device_data

## 用于解密TrustDeviceSDK上报的数据

### 请求参数

| **类型** | **是否必填** | **参数描述**                                               |
| -------- | ------------ | ---------------------------------------------------------- |
| string   | true         | verityData:需要检验的数据明文，是trustdevice表中的data字段 |
| string   | true         | verityValue:校验的数据密文，是trustdevice表中的value字段   |

### 返回参数

| **类型** | **描述**                                                     |
| -------- | ------------------------------------------------------------ |
| long     | 从校验数据中抠出来的系统环境信息，每位二进制代表一种环境检测 |

### 使用例子

```
 select get_trust_device_data('CiX/4q+YC9I=','vUE5HIu7TqU=');
->-5578164706405777409
```

# decode_base64data

## base64编码字符串，还原成short数组,输出short数组集合

### 请求参数

| **类型** | **是否必填** | **参数描述**     |
| -------- | ------------ | ---------------- |
| string   | true         | base64编码字符串 |

### 返回参数

| **类型** | **描述**       |
| -------- | -------------- |
| short    | short 数组集合 |

### 使用例子

```
 select decode_base64data('CiX/4q+YC9I=');
->[10, 37, 226, 11]
```

# get_levels

## 字符串切分层次("/"分隔符)

### 请求参数

| **类型** | **是否必填** | **参数描述**                            |
| -------- | ------------ | --------------------------------------- |
| string   | true         | 路径(/A/B/C)                            |
| int      | true         | 切分层次, 如<=0，则返回输入数据的层级数 |

### 返回参数

| **类型** | **描述**         |
| -------- | ---------------- |
| string   | 切分后层次字符串 |

### 使用例子

```
select get_levels('login/load_left/load_left_left',1) ==>> login
select get_levels('login/load_left/load_left_left',2) ==>> login/load_left
select get_levels('login/load_left/load_left_left',3) ==>> login/load_left/load_left_left
select get_levels('login/load_left/load_left_left',-1) ==>> 3
```

positive_integer

判断是否是正整数

### 请求参数

| **类型** | **是否必填** | **参数描述**   |
| -------- | ------------ | -------------- |
| string   | true         | 需要判断的内容 |
| boolean  | false        | 是否对内容trim |

### 返回参数

| **类型** | **描述**     |
| -------- | ------------ |
| boolean  | 是否是正整数 |

### 使用例子

```
 select is_positive_integer('1 ',true);==>>true
```

# siphash

### 请求参数

| **类型** | **是否必填** | **参数描述** |
| -------- | ------------ | ------------ |
| string   | true         | value        |
| long     | false        | k0           |
| long     | false        | k1           |

### 返回参数

| **类型** | **描述**   |
| -------- | ---------- |
| long     | hash value |

### 使用例子

```
 select siphash('a');
->-7583489610679606711
```

# jsonarray_to_list

## JSONArray2List

## json数组转为list

### 请求参数

| **类型** | **是否必填** | **参数描述**   |
| -------- | ------------ | -------------- |
| string   | true         | json数组字符串 |

### 返回参数

| **类型** | **描述**       |
| -------- | -------------- |
| list     | list结构的数据 |

### 使用例子

```
  select jsonarray_to_list('["AAA","BBB",{"name":"wuzhiliang"},"VVV"]');
->["\"AAA\"","\"BBB\"","{\"name\":\"wuzhiliang\"}","\"VVV\""]
```

# smart_date_format

## 多功能时间格式化

## 时间格式化，支持多种时间字符串格式转换

### 请求参数

| **类型** | **是否必填** | **参数描述**                      |
| -------- | ------------ | --------------------------------- |
| string   | true         | 要格式化的字符串                  |
| string   | false        | 输出格式，默认yyyy-MM-dd HH:mm:ss |
| string   | false        | 输入格式                          |

### 返回参数

| **类型** | **描述**       |
| -------- | -------------- |
| string   | 格式化后的时间 |

### 使用例子

```
select smart_date_format('Tue Jan 22 10:58:34 HKT 2013')==>>2013-01-22 10:58:34;
支持多种格式自动判断：
"EEE, dd MMM yy HH:mm:ss z", "EEE, dd MMM yyyy HH:mm:ss z", "EEE, dd MMM yy HH:mm:ss", "EEE, MMM dd yy HH:mm:ss", "EEE, dd MMM yy HH:mm z", "EEE dd MMM yyyy HH:mm:ss", "dd MMM yy HH:mm:ss z", "dd MMM yy HH:mm z", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:sszzzz", "yyyy-MM-dd'T'HH:mm:ss z", "yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.SSSz", "yyyy-MM-dd'T'HHmmss.SSSz", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mmZ", "yyyy-MM-dd'T'HH:mm'Z'", "dd MMM yyyy HH:mm:ss z", "dd MMM yyyy HH:mm z", "yyyy-MM-dd", "MMM dd, yyyy", "EEE MMM dd HH:mm:ss z yyyy"
```

# json_ext

## json转换为struct结构类型

## json转换为结构类型 Map<String,String>, List<String>, List<List<String>>, List<Map<String,String>>

### 请求参数

| **类型** | **是否必填** | **参数描述** |
| -------- | ------------ | ------------ |
| string   | true         | json字符串   |

### 返回参数

| **类型** | **描述**                                                     |
| -------- | ------------------------------------------------------------ |
| struct   | {"tbase":null,"tlist":null,"tlistlist":null,"tlistmap":null,"tmap":null} |

### 使用例子

```
 select json_ext('test'); ==>>{"tbase":"test","tlist":null,"tlistlist":null,"tlistmap":null,"tmap":null}
select json_ext('{"weight":8,"type":"apple"}') ==>>{"tbase":null,"tlist":null,"tlistlist":null,"tlistmap":null,"tmap":{"weight":"8","type":"apple"}}
select json_ext('[7,8]'); ==>>{"tbase":null,"tlist":["7","8"],"tlistlist":null,"tlistmap":null,"tmap":null}
select json_ext('[[7,8],["weight","pear"]]') ==>>{"tbase":null,"tlist":null,"tlistlist":[["7","8"],["weight","pear"]],"tlistmap":null,"tmap":null}
select json_ext('[{"weight":8,"type":"apple"},{"weight":9,"type":"pear"}]') ==>>{"tbase":null,"tlist":null,"tlistlist":null,"tlistmap":[{"weight":"8","type":"apple"},{"weight":"9","type":"pear"}],"tmap":null}
```

