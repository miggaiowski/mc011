package interp;

class Table {
    String id; int value; Table tail;
    
    // constructor
    Table(String i, int v, Table t) {
        id = i;
        value = v;
        tail = t;
    }
    
    // insert new item (id, value) in the front of the list
    static Table update(Table t1, String i, int v) {
        Table t2 = new Table(i, v, t1);
        return t2;
    }
    
    // returns the value for id i or -1 if id not found    
    static int lookup(Table t, String i) {
        while (t != null) {
            if (t.id == i)
                return t.value;
            t = t.tail;
        }
        System.out.println("  Error: using the variable *** " + i + " *** before its definition");
        return -100;
    }
}