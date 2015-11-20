题目是给一堆people，每人有skills，再给一堆tasks，每个有需要的skills，返回bool值是否所有任务都可完成。然后一通讨论corner case。follow up问people之间不能合作怎么做。这个代码没写完，中午有点懵，反应也慢了。时间一到被小哥打断拍照走人。
answer:
或者换一种角度，每个人就是一个bitmap，每一位是某一个skill，0代表不会，1代表会。同理每一个task就是一个bitmap,每一位也是skill，
0代表需要，1代表不需要，做与运算，看看每个人的bitmap能不能包含task的bitmap。
