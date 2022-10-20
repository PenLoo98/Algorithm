class LinkedList(data="", next=None, prev=None):
    def __init__(self, data, prev=None, next=None):
        self.data = data
        self.next = next
        self.prev = prev

a = LinkedList("a")
b = LinkedList("b")
c = LinkedList("c")
a = LinkedList("a").next("b"). next("c")
b = LinkedList("b").prev("a"). next("c")
c = LinkedList("c").next("a"). prev("b")
print(a)
print(a.next)
print(a.prev)
print(b)
print(b.next)
print(b.prev)
print(c)
print(c.next)
print(c.prev)



