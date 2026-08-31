import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: .fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const Home(),
    );
  }
}

class Home extends StatefulWidget {
  const new({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  static const platform = const MethodChannel("floating_button");

  int count = 0;
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Floating Button Demo"),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text("$count", textAlign: TextAlign.center, style: TextStyle(fontSize: 50)), 
            ElevatedButton(child: Text("Create"), onPressed: (){
              platform.invokeMethod("create");
            },),
            ElevatedButton(onPressed: () {
              platform.invokeMethod("show");
            }, child: Text("Show")),
            ElevatedButton(onPressed: () {
              platform.invokeMethod("hide");
            }, child: Text("Hide"))
          ],
        )
      ),
    );
  }
}