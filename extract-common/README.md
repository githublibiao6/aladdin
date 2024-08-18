1.License认证（只校验有效期）

https://blog.csdn.net/qq_35512802/article/details/136497252

##1.1
## 1. 生成私匙库
# validity：私钥的有效期（单位：天）
# alias：私钥别称
# keystore: 私钥库文件名称(生成在当前目录)
# storepass：私钥库的密码(获取keystore信息所需的密码) 
# keypass：私钥的密码
# dname 证书个人信息
# 	CN 为你的姓名
#	OU 为你的组织单位名称
#	O 为你的组织名称
#	L 为你所在的城市名称
#	ST 为你所在的省份名称
#	C 为你的国家名称 或 区号
keytool -genkeypair -keysize 1024 -validity 365 -alias "privateKey" -keystore "privateKeys.keystore" -storepass "public_password12345" -keypass "private_password12345" -dname "CN=cles, OU=H, O=L, L=HZ, ST=ZJ, C=CN"

## 2. 把私匙库内的公匙导出到一个文件当中
# alias：私钥别称
# keystore：私钥库的名称(在当前目录查找)
# storepass: 私钥库的密码
# file：证书名称
keytool -exportcert -alias "privateKey" -keystore "privateKeys.keystore" -storepass "public_password12345" -file "certfile.cer"

## 3. 再把这个证书文件导入到公匙库
# alias：公钥别称
# file：证书名称
# keystore：公钥文件名称(生成在当前目录)
# storepass：私钥库的密码
keytool -import -alias "publicCert" -file "certfile.cer" -keystore "publicCerts.keystore" -storepass "public_password12345"

