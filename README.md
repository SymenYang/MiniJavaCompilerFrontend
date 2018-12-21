# CompileFrontend
## 组员分工：
单人分组：100%
## 运行代码的方式：
### 直接测试运行TestSample
```
$ python src/Main.py PATHtoTestSample  
// TestSample的文件 在src/TestData目录下，路径指定相对路径
```
### 重新编译Antlr4
```
$ cd src
$ Antlr4 MiniJava.g4 -visitor -Dlanguage=Python3
```
## 运行平台：
理论上全平台，测试时使用的MacOS，python3.6.7 java 1.8.0_121
## 依赖说明：
需要使用Antlr4 version: 4.7.1
python需安装Antlr run time,命令为：
```
$ pip install antlr4-python3-runtime==4.7.1
```
