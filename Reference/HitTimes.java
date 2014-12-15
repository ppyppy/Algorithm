新鲜出炉的dropbox电话面经， 叫我写个计数函数，返回5分钟内hit()被运行了几次.


看起来容易，做起来不简单啊。getHits的输出都到long级别了，用linkedList来数数
是不可能了。只能用static变量按秒进行计数，然后还要有circular buffer来处理5分
钟的时间窗口。真是一个题什么都涉及到了。

(我的理解: 因为每秒钟被调用次数很多次可以,所以每5秒清零计数器就不精确,可能在清零读取的时候后面半秒还有很多次hit,因此要用circular buffer
来存贮每秒的计数).

两个function;

void hit()

long getHits() //返回五分钟内hit了几次


I wrote the code based on LZ's description.
Do you guys think this is correct?
Any suggestion/improvement is appreciated!

class HitsCounter {
private:
    vector<int> hitcnt; // stores the hit for each second
    long long total;    // always keeps the current hit count
    long long last;     // the time of last hit
    int size;           // size of hitcnt array, for this question set to 
300
public:
    HitsCounter(int secondCnt) {
        // in this case, secondCnt shoule be 300
        hitcnt = vector<int>(secondCnt, 0);
        total = 0;
        size = secondCnt;
    }
    
    long long getHit() {
        // total always stores the current hit count
        return total;
    }
    
    void hit(long long cur) {
        // suppose the unit of time() is second
        // long long cur = time();
        // if cur > last, some previous value need to be reset to 0
        // also, if t - last > size, we've set 0 for entire queue, no need 
to continue
        for (int t = last + 1; t <= cur && t - last <= size; t++) {
            // update total, and reset the specific count to 0
            total -= hitcnt[t % size];
            hitcnt[t % size] = 0;
        }
        
        // update hitcnt, total and last for this hit
        hitcnt[cur % size]++;
        total++;
        last = cur;
    }
};
