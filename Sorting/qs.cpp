void swap(int arr[],int i,int j)
{
    int t=arr[i];
    arr[i]=arr[j];
    arr[j]=t;
}

void quickSort(int A[],int l,int h)
{
    if(l < h)
    {
        int p=partition(A,l,h);
        quickSort(A,l,p-1);
        quickSort(A,p+1,h);
    }
}

int partition(int A[],int l,int h)
{
    int k=h;
    int pivot=A[l];
    for(int i=h;i>l;i--)
    {
        if(A[i]>pivot)
        {
            swap(A,k,i);
            k--;
        }
    }
    swap(A,l,k);
    return k;
}