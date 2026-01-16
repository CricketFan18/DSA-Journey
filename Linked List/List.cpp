#include<bits/stdc++.h>
using namespace std;

class Node
{
public:
    int val;
    Node* next;
    Node() : val(0), next(nullptr) {}
    Node(int x) : val(x), next(nullptr) {}
};

class LinkedList
{
private:
    Node *head;
public:
    LinkedList()
    {
        head=nullptr;
    }

    void partition(int x) 
    {
        Node* p=nullptr;
        Node* dummy=new Node(-1);
        Node *n=head;
        Node *t=dummy;
        while(n!=nullptr) 
        {
            if(head->val>x)
            {
                t->next=head;
                n=n->next;
                head=head->next;
                t=t->next;
            }
            else if(n->val>x)
            {
                t->next=n;
                n=n->next;
                t=t->next;
            }
            else
            {
                if(p==nullptr) p=n;
                p->next=n;
                p=n;
                n=n->next;
            }
        }   
        p->next=dummy->next;
        t->next=nullptr;
    }

    void inputB()
    {        
        Node *newNode =new Node;
        cout << "Enter value at beginning: ";
        cin >> newNode->val;
        newNode->next=head;
        head=newNode;        
    }

    void inputE()
    {
        Node *newNode=new Node;
        cout << "Enter value at end: ";
        cin >> newNode->val;
        newNode->next=nullptr;
        if(head==nullptr)
        {
            head=newNode;
        }
        else
        {
            Node *temp=head;
            while(temp->next!=nullptr)
            {
                temp=temp->next;
            }
            temp->next=newNode;
        }
    }

    int outputB()
    {
        if(head==nullptr)
        {
            return -1;
        }
        else
        {
            int t=head->val;
            Node *temp=head;
            head=head->next;
            delete temp;
            return t;
        }
    }


    void display()
    {
        if(head==nullptr)
        {
            printf("No nodes\n");
        }
        else
        {
            Node *temp=head;
            while(temp!=nullptr)
            {
                printf("%d",temp->val);
                if(temp->next!=nullptr) printf(" -> ");
                temp=temp->next;
            }
            printf("\n");
        }
    }

};

 Node *merge(Node *list1,Node *list2)
    {
        Node *ob=nullptr;
        while(list1!=nullptr && list2!=nullptr)
        {
            if(list1->val == list2->val)
            {
                Node *n1=new Node;
                Node *n2=new Node;
                n1->val=list1->val;
                n2->val=list2->val;
                if(ob==nullptr)
                {
                    ob=n1;
                    n1->next=n2;
                    n2->next=nullptr;
                }
                else{

                }
                list1=list1->next;
                list2=list2->next;
            }
            else if(list1->val < list2->val)
            {
                Node *n=new Node;
                n->val=list1->val;
                n->next=nullptr;
                if(ob=nullptr)
                {
                    ob=n;
                }
                else
                {
                    Node *temp=ob;
                    while(temp->next!=nullptr)
                    {
                        temp=temp->next;
                    }
                    temp->next=n;
                }
                list1=list1->next;
            }
            else
            {
                Node *n=new Node;
                n->val=list2->val;
                n->next=nullptr;
                if(ob=nullptr)
                {
                    ob=n;
                }
                else
                {
                    Node *temp=ob;
                    while(temp->next!=nullptr)
                    {
                        temp=temp->next;
                    }
                    temp->next=n;
                }
                list2=list2->next;
            }
        }
        return ob;

    }



int main()
{
    LinkedList list;
    list.display();
    list.inputB();
    list.inputB();
    list.display();
    list.partition(2);
    list.display();
}
